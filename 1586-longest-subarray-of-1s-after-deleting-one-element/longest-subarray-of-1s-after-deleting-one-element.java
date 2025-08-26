class Solution {
    public int longestSubarray(int[] nums) {
        
        int left = 0,right=0;
        int n = nums.length;

        int len = 0;
        int zcount =0;
        int ocount =0;
        for(int i=0; i<n; i++){
            if(nums[i]==0) zcount++;
        }

        if(zcount ==0) return n-1;
        zcount=0;
        while(right < n){

            if(nums[right]==1) ocount++;
            else zcount++;

            while(zcount >1){
                if(nums[left]==0) zcount--;
                ocount -= nums[left];
                left++;
            }

            len = Math.max(len,ocount);
            right++;
        }

        return len;
    }
}