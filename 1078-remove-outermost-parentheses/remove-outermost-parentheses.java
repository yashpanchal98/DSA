class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder sb = new StringBuilder();
        int open=0,close=0;

        int left =0,right=0;

        while(right<s.length()){

            if(s.charAt(right)=='(') open++;
            else close++;

            if(open==close){
                sb.append(s.substring(left+1,right));
                left = right+1;
            }
            right++;
        }
        return sb.toString();
    }
}