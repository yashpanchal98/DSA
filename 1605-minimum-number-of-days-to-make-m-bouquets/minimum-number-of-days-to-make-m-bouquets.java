class Solution {

    public boolean canMake(int bloomDay[], int m, int k, int mid){

        int cnt = 0;
        int ans = 1;
        int b = 0;
        for(int i=0; i<bloomDay.length; i++){
            
            if(bloomDay[i] <= mid){
                cnt++;
                if(cnt >= k) {
                    b++;
                    cnt=0;
                }
            } else {
                cnt = 0;
            }
        }
        return b>=m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        int high = Integer.MIN_VALUE;
        for(int num : bloomDay) high = Math.max(num,high);

        int low = 1;
        int ans = -1;


        while(high >= low){
            int mid = low + (high-low)/2;

            if(canMake(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}