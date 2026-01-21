class Solution {

    public int helper(String s, int idx, int memo[]){

        if(idx == s.length()) return 1;

        if(s.charAt(idx)=='0') return 0;

        if(memo[idx] != -1) return memo[idx];
        // all single
        int w1 = helper(s,idx+1,memo);

        // pairs
        if(idx+1 < s.length() && Integer.parseInt(s.substring(idx,idx+2)) <= 26){
            w1 += helper(s,idx+2,memo);
        }

        return memo[idx] = w1;
    }

    public int numDecodings(String s) {
        int memo[] = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return helper(s,0,memo);
    }
}