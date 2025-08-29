class Solution {
    public long flowerGame(int n, int m) {
        
        long ans = 0;
        int odd = (m+1)/2;
        int even = m/2;

        for(int i=1; i<=n; i++){
            if(i%2==0) ans += odd;
            else ans += even;
        }
        return ans;
    }
}