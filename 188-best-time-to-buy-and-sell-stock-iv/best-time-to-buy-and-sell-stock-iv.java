class Solution {
    
    private Integer[][][] dp; 

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][k+1]; 
        return dfs(prices, 0, 1, 0, n,k);
    }

    private int dfs(int[] prices, int idx, int canBuy, int cap, int n, int k) {
        if (idx == n || cap == k) return 0;

        if (dp[idx][canBuy][cap] != null) {
            return dp[idx][canBuy][cap];
        }

        int profit;
        if (canBuy == 1) {
            int buy = -prices[idx] + dfs(prices, idx + 1, 0, cap, n,k);
            int notBuy = dfs(prices, idx + 1, 1, cap, n,k);
            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[idx] + dfs(prices, idx + 1, 1, cap + 1, n,k);
            int notSell = dfs(prices, idx + 1, 0, cap, n,k);
            profit = Math.max(sell, notSell);
        }

        return dp[idx][canBuy][cap] = profit;
    }
}