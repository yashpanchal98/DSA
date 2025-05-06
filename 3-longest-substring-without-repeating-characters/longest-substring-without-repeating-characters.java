class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> hs  = new HashSet<>();

        int left=0,right=0,len=0;
        int n = s.length();

        while(right < n){
            
            if(hs.contains(s.charAt(right))){
                while(s.charAt(left) != s.charAt(right)){
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.remove(s.charAt(left));
                left++;
            } 
                hs.add(s.charAt(right));
                len = Math.max(right-left+1,len);
            
            right++;
        }
        return len;
    }
}