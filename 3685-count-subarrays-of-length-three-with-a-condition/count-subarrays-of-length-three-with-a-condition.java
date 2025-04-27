class Solution {

    public int countSubarrays(int[] nums) {
        
        int left = 0, right = 2;
        int cnt = 0;
        while (right < nums.length) {
            if (2 * (nums[left] + nums[right]) == nums[left + 1]) {
                cnt++;
            }
            left++;
            right++;
        }
        return cnt;
    }
}