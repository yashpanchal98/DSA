class Solution {
    public int removeDuplicates(int[] nums) {
        
        int idx = 0;

        for(int i=0; i<nums.length-1 ;i++){
            if(nums[i]!=nums[i+1]){
                idx++;
                nums[idx] = nums[i+1];
            }
        }
        return idx+1;
    }
}