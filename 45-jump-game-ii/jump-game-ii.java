class Solution {

    public int helper(int[] nums, int idx, int n, int[] dp) {
        if (idx >= n - 1) return 0; 
        if (dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            int sub = helper(nums, idx + i, n, dp);
            if (sub != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + sub); 
            }
        }

        return dp[idx] = ans;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, n, dp);
    }
}