class Solution {

    public boolean isPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while(j>=i){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;

    }

    public void helper(String s, int idx, List<List<String>> ans, List<String> list) {

        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            String str = s.substring(idx,i+1);
            if(isPalindrome(str)){
                list.add(str);
                helper(s,i+1,ans,list);
                list.remove(list.size()-1);
            } 
        }
    }

    public List<List<String>> partition(String s) {
        
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        helper(s,0,ans,list);
        return ans;
    }
}