class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean dp[] = new boolean[n];
        dp[0] = true;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n && j<=i+nums[i]; j++){
                if(dp[i]==true) dp[j] = true;
            }
        }
        return dp[n-1];
    }
}