class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        int left=0,right=0;
        long ans = 0,sum=0;

        while(right < nums.length){
            sum += nums[right];
            long score = (right-left+1)*sum;

            while(score >= k && left<=right){
                sum-=nums[left];
                left++;
                score = (right-left+1) * sum;
            } 

            ans += right-left+1;
            right++;
        }
        return ans;
    }
}