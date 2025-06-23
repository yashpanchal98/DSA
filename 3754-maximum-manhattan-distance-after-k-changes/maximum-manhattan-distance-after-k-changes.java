class Solution {
    public int maxDistance(String s, int k) {
        
        int x=0,y=0;
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='N'){
                y++;
            } else if(ch=='S'){
                y--;
            } else if(ch=='E'){
                x++;
            } else {
                x--;
            }

            int initDist = Math.abs(x)+Math.abs(y);

            int possDist = Math.min(initDist + 2*k, i+1);

            ans = Math.max(ans,possDist);
        }
        
       return ans;
    }
}