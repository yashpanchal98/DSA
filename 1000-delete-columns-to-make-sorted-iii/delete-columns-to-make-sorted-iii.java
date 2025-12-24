class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int m = strs[0].length();
        int dp[] = new int[m];
        Arrays.fill(dp, 1);
        int ans = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) {
            boolean found = true;

                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found)
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
            }
            ans = Math.max(ans, dp[j]);
        }
        return m - ans;
    }
}