class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        int n = stones.size();
        vector<long long> prefix(n);
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // dp[i] = best score difference for the current player,
        // given the cut point is at index i (first i+1 stones merged)
        long long dp = prefix[n - 1]; // only choice when cutting at the last index
        for (int i = n - 2; i >= 1; i--) {
            dp = max(dp, prefix[i] - dp);
        }

        return (int)dp;
    }
};