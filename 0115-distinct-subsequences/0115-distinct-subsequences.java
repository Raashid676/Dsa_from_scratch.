
class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // Empty t can be formed in exactly 1 way
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            // Empty t
            dp[i][0] = 1;

            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    // Two choices:
                    // 1. Use s[i-1]
                    // 2. Skip s[i-1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                } else {

                    // Can't use s[i-1], so skip it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}

