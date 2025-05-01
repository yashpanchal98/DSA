class Solution {

    public void helper( List<String> list,StringBuilder sb,int n,int open, int close){

        // base case
        if(open == n && close == n){
            list.add(sb.toString());
            return;
        }
        if(open > n || close > open) return;

        sb.append('(');
        helper(list,sb,n,open+1,close);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        helper(list,sb,n,open,close+1);
        sb.deleteCharAt(sb.length()-1);

    }

    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(list, sb, n, 0, 0);
        return list;
        
    }
}