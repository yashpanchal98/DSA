class Solution {

    private int[] buildLPSLength(String s) {
        int[] lpsLength = new int[s.length()];
        int len = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(j) == s.charAt(len)) {
                len++;
                lpsLength[j] = len;
                j++;
            } else {
                if (len == 0) {
                    j++;
                } else {
                    len = lpsLength[len - 1];
                }
            }
        }
        return lpsLength;
    }
    
    public String shortestPalindrome(String s) {
        StringBuilder sReverse = new StringBuilder(s).reverse();
        
        String concat = s + "@" + sReverse.toString();
        int[] lpsLength = buildLPSLength(concat);
        int palindromeLengthAtStart = lpsLength[concat.length() - 1];
        
        String toAdd = sReverse.substring(0, s.length() - palindromeLengthAtStart);
        
        return toAdd + s;
    }
}