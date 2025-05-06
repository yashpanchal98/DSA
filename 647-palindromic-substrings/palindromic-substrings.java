class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){

            int left = i;
            int right = i;

            while(left >= 0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                ans++;
            }

            left = i;
            if(i<n) right = i+1;
            while(left >=0 && right <n && s.charAt(left)==s.charAt(right)){
                ans ++;
                left--;
                right++;
            }

        }
        return ans;   
    }
}