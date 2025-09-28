class Solution {
    public long splitArray(int[] nums) {
        
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) totalSum += num;

        long left = nums[0];
        int idx = 1;
        while (idx < n && nums[idx] > nums[idx - 1]) {
            left += nums[idx];
            idx++;
        }
        boolean valid1 = isDecreasing(nums, idx, n - 1);
        long one = valid1 ? Math.abs(totalSum - 2 * left) : Long.MAX_VALUE;

        long right = nums[n - 1];
        int j = n - 2;
        while (j >= 0 && nums[j] > nums[j + 1]) {
            right += nums[j];
            j--;
        }
        boolean valid2 = isIncreasing(nums, 0, j);
        long two = valid2 ? Math.abs(2 * right - totalSum) : Long.MAX_VALUE;

        long ans = Math.min(one, two);
        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    public boolean isIncreasing(int[] nums, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] <= nums[i - 1]) return false;
        }
        return true;
    }

    public boolean isDecreasing(int[] nums, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] >= nums[i - 1]) return false;
        }
        return true;
    }
}