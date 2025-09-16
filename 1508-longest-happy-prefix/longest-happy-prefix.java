class Solution {
    public String longestPrefix(String s) {
        
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int j = 1;

        while (j < n) {
            if (s.charAt(j) == s.charAt(len)) {
                len++;
                lps[j] = len;
                j++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    j++;
                }
            }
        }
        return s.substring(0, lps[n - 1]);
    }
}