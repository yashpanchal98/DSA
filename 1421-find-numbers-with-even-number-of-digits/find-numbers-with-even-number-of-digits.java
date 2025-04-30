class Solution {
    public int findNumbers(int[] nums) {
        
        int ans = 0;
        for(int num : nums){
            int cnt =0;
            int n = num;

            while(n>0){
                cnt++;
                n=n/10;
            }
            if(cnt%2==0) ans++;
        }   
        return ans;
    }
}