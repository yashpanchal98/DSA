class Solution {

    static final int MOD = 1_000_000_007;

    public int helper(int n, int i, int prev1, int prev2, int prev3, int[][][][] dp) {
        if (i == n) return 1;

        if (dp[i][prev1 + 1][prev2 + 1][prev3 + 1] != -1)
            return dp[i][prev1 + 1][prev2 + 1][prev3 + 1];

        int cnt = 0;

        for (int r = 0; r < 3; r++) {
            if (r == prev1) continue;
            for (int y = 0; y < 3; y++) {
                if (y == prev2 || y == r) continue;
                for (int g = 0; g < 3; g++) {
                    if (g == prev3 || g == y) continue;
                    cnt = (cnt + helper(n, i + 1, r, y, g, dp)) % MOD;
                }
            }
        }

        dp[i][prev1 + 1][prev2 + 1][prev3 + 1] = cnt;
        return cnt;
    }

    public int numOfWays(int n) {
        int[][][][] dp = new int[n][4][4][4];

        for (int i = 0; i < n; i++)
            for (int a = 0; a < 4; a++)
                for (int b = 0; b < 4; b++)
                    for (int c = 0; c < 4; c++)
                        dp[i][a][b][c] = -1;

        return helper(n, 0, -1, -1, -1, dp);
    }
}