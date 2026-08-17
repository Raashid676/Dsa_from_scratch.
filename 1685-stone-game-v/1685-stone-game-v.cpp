
class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        int n = stoneValue.size();
        vector<long long> prefix(n + 1, 0);
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stoneValue[i];

        auto sum = [&](int i, int j) -> long long {
            // sum of stones[i..j] inclusive
            return prefix[j + 1] - prefix[i];
        };

        vector<vector<int>> dp(n, vector<int>(n, 0));

        // iterate by increasing subarray length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = 0;
                for (int k = i; k < j; k++) {
                    long long leftSum = sum(i, k);
                    long long rightSum = sum(k + 1, j);
                    int cand;
                    if (leftSum < rightSum) {
                        cand = dp[i][k] + (int)leftSum;
                    } else if (leftSum > rightSum) {
                        cand = dp[k + 1][j] + (int)rightSum;
                    } else {
                        cand = max(dp[i][k], dp[k + 1][j]) + (int)leftSum;
                    }
                    best = max(best, cand);
                }
                dp[i][j] = best;
            }
        }

        return dp[0][n - 1];
    }
};