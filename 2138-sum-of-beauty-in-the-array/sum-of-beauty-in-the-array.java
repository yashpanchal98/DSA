class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int n = nums.length;
        int minLeft[] = new int[n];
        int minRight[] = new int[n];

        minLeft[0] = nums[0];
        minRight[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            minLeft[i] = Math.max(minLeft[i-1],nums[i]);
        }
        for(int i=n-2; i>=0; i--){
            minRight[i] = Math.min(minRight[i+1],nums[i]);
        }

        int beauty = 0;
        for(int i=1; i<n-1; i++){

            if(minLeft[i-1]< nums[i] && nums[i] < minRight[i+1]) beauty += 2;
            else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]) beauty += 1;
        }
        return beauty;
    }
}