class Solution {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int ans = 0;

        int n = nums.length - 1;

        for (int i = n; i > 1; i--) {
            int l = nums[i-2];
            int r = nums[i-1];
            if(l+r>nums[i]) return l+r+nums[i];
        }
        return ans;
    }
}