class Solution {
    public boolean doesAliceWin(String s) {
        
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if("aeiou".indexOf(s.charAt(i)) != -1) cnt++;
        }

        if(cnt == 0) return false;
        if(cnt%2 !=0) return true;

        return true;
    }
}