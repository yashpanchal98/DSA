class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = coins.length;
        int dp[][] = new int[m + 1][amount + 1];
        
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount+1;
        }
        
        for (int i = 1; i <= m; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][amount] > amount ? -1 : dp[m][amount];
    }
}
