class Solution {
    
    private Integer[][][] dp; 

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][3]; 
        return dfs(prices, 0, 1, 0, n);
    }

    private int dfs(int[] prices, int idx, int canBuy, int cap, int n) {
        if (idx == n || cap == 2) return 0;

        if (dp[idx][canBuy][cap] != null) {
            return dp[idx][canBuy][cap];
        }

        int profit;
        if (canBuy == 1) {
            int buy = -prices[idx] + dfs(prices, idx + 1, 0, cap, n);
            int notBuy = dfs(prices, idx + 1, 1, cap, n);
            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[idx] + dfs(prices, idx + 1, 1, cap + 1, n);
            int notSell = dfs(prices, idx + 1, 0, cap, n);
            profit = Math.max(sell, notSell);
        }

        return dp[idx][canBuy][cap] = profit;
    }
}