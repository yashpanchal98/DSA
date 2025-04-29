class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        long cnt = 0;
        int max = -1;
        long ans = 0;

        for(int num: nums) max = Math.max(num,max);
        int left=0,right=0,n=nums.length;

        while(right < n) {
            
            if(nums[right]==max) cnt++;
            while(cnt>=k){
                if(nums[left]==max) cnt--;
                left++;
                ans += n-right;
            }
            right++;
        }
        return ans;
    }
}