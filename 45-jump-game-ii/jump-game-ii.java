class Solution {
    public int jump(int[] nums) {

        int left = 0,right = 0,jumps = 0;
        int n = nums.length;   

        while(right < n-1){
            int far = 0;

            for(int i=left; i<=right; i++){
                far = Math.max(far,i+nums[i]);
            }
            jumps++;
            left = right+1;
            right = far;

            if(far >= n-1) return jumps;
        }
        return jumps;
    }
}