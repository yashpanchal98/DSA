class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        int ans = Integer.MIN_VALUE;
        while(j>i){
            int pair = nums[i] + nums[j];
            ans = Math.max(ans,pair);
            i++;
            j--;
        }
        return ans;
    }
}