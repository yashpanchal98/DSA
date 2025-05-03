class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int prefix[] = new int[n];   
        int suffix[] = new int[n];   
        int max = Integer.MIN_VALUE;

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            prefix[i] = (prefix[i - 1] == 0 ? 1 : prefix[i - 1]) * nums[i];
            suffix[n - i - 1] = (suffix[n - i] == 0 ? 1 : suffix[n - i]) * nums[n - i - 1];
        }  

        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.max(prefix[i], suffix[i]));
        }
        return max;
    }
}