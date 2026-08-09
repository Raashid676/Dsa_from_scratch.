class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        vector<int> suffixSum(n + 1, 0);
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // dp[i][m] = max stones current player can get from piles[i:] given M = m
        // m can range from 1 to n, so size accordingly
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, -1));

        function<int(int, int)> solve = [&](int i, int m) -> int {
            if (i >= n) return 0;
            if (i + 2 * m >= n) return suffixSum[i];

            if (dp[i][m] != -1) return dp[i][m];

            int best = 0;
            for (int x = 1; x <= 2 * m; x++) {
                int nextM = max(m, x);
                best = max(best, suffixSum[i] - solve(i + x, nextM));
            }

            dp[i][m] = best;
            return best;
        };

        return solve(0, 1);
    }
};