class Solution {

    public int helper(int prices[],int n, int idx, int dp[][], int canBuy){

        if(idx>=n) return 0;

        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int profit = 0;
        if(canBuy == 1){
            int buy = -prices[idx] + helper(prices,n,idx+1,dp,0);
            int notBuy = helper(prices,n,idx+1,dp,1);
            profit = Math.max(buy,notBuy);
        } else {
            int sell = prices[idx] + helper(prices,n,idx+2,dp,1);
            int notSell = helper(prices,n,idx+1,dp,0);
            profit = Math.max(sell,notSell);
        }

        return dp[idx][canBuy] = profit;

    }

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int i=0; i<n; i++){
            for(int j=0;j<2; j++){
                dp[i][j] = -1;
            }
        }

        return helper(prices,n,0,dp,1);
    }
}