class Solution {
    public int maxSubArray(int[] nums) {
        
        int curr = 0;
        int ans = Integer.MIN_VALUE;

        for(int num: nums){
            curr += num;
            ans = Math.max(curr,ans);
            if(curr < 0) curr = 0;
        }
        return ans;
    }
}