class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(high >= low){

            int mid = (low + high)/2;

            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            if(nums[low] <= nums[mid]){
                // Left half is sorted
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            } else {
                // Right half is sorted
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}