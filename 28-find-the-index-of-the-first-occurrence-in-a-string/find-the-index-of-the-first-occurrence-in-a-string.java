class Solution {

    public int[] buildLPS(String needle){
        int lps[] = new int[needle.length()];

        int len = 0;
        int j = 1;

        while(j<needle.length()){
            
            if(needle.charAt(len)==needle.charAt(j)){
                len++;
                lps[j] = len;
                j++;
            } else {
                if(len > 0){
                    len = lps[len-1];
                } else {
                    j++;
                }
            }
        }
        return lps;
    }

    public int strStr(String heystack, String needle) {
        
        int lps[] = buildLPS(needle);

        int i=0,j=0;

        while(i < heystack.length()){

            if(heystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            } else {
                if(j>0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }

            if(j==needle.length()){
                return i-needle.length();
            }
        }
        return -1;
    }
}