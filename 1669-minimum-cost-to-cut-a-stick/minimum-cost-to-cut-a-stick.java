class Solution {

    public int helper(int cuts[], int i, int j, int dp[][]){

        if(i+1 >= j) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        for(int k=i+1; k<j; k++){
            int c1 = helper(cuts,i,k,dp);
            int c2 = helper(cuts,k,j,dp);
            int c3 = cuts[j]-cuts[i];
            ans = Math.min(c1+c2+c3,ans);
        }
        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        int arr[] = new int[m+2];
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        int dp[][] = new int[m+2][m+2];
        for(int i=0; i<m+2; i++){
            for(int j=0; j<m+2; j++){
                dp[i][j] = -1;
            }
        }

        arr[m+1] = n;
        Arrays.sort(arr);
        return helper(arr,0,m+1,dp);
    }
}