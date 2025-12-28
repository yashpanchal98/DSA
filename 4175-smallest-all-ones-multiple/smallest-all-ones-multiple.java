class Solution {
    public int minAllOneMultiple(int k) {
        int  s = 0;
        if(k%2==0 || k%5==0)return -1;
        for(int i =1;i<=k;i++){
            s = (s*10 + 1)%k;
            
            if(s%k==0) return i;
        }
        return -1;
    }
}