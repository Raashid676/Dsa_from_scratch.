
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        // dp[0] = false (no stones left, current player to move loses)
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break; // found a winning move, no need to check further
                }
            }
        }
        
        return dp[n];
    }
}