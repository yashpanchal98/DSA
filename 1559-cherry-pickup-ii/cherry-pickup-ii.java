class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return helper(grid, 0, 0, n-1, m, n, dp);
    }

    public int helper(int[][] grid, int i, int j1, int j2, int m, int n, int dp[][][]) {

        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) return Integer.MIN_VALUE;

        if (i == m-1) {
            return (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int result = Integer.MIN_VALUE;

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                int next = helper(grid, i+1, j1+k, j2+l, m, n, dp);
                if (next != Integer.MIN_VALUE) {
                    cherries += next;
                }
                result = Math.max(result, cherries);
            }
        }

        return dp[i][j1][j2] = result;
    }
}
