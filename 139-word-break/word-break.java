class Solution {
    public boolean helper(String s, int si, int ei, HashSet<String> wd, int[][] dp) {
        if (si > ei) return true; 
        
        if (dp[si][ei] != -1) return dp[si][ei] == 1;  
        
        boolean res = false;
        for (int split = si; split <= ei; split++) {  
            String word = s.substring(si, split + 1);
            if (wd.contains(word) && helper(s, split + 1, ei, wd, dp)) {
                res = true;
                break;
            }
        }
        
        dp[si][ei] = res ? 1 : 0; 
        return res;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, 0, n-1, new HashSet<>(wordDict), dp);  
    }
}
