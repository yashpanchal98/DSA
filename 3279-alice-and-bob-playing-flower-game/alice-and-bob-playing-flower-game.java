class Solution {
    public long flowerGame(int n, int m) {
        
        int odd=0;
        int even=0;
        long ans = 0;

        if(m%2==0) odd = m/2;
        else odd = m/2 + 1;
        even = m/2;

        for(int i=1; i<=n; i++){
            if(i%2==0) ans += odd;
            else ans += even;
        }
        return ans;
    }
}