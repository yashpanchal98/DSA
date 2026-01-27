class Solution {
    public int longestConsecutive(int[] nums) {
        

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int last = nums[0];
        int ans = 1;
        int curr = 1;

        for(int i=1; i<nums.length; i++){

            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] == nums[i-1] + 1){
                last = nums[i];
                curr++;
            } else{
                curr = 1;
            }
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}