class Solution {

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxK = Math.min(m, n);

        for (int k = maxK; k >= 1; k--) {
            for (int i = 0; i <= m-k; i++) {
                for (int j = 0; j <= n-k; j++) {
                    if (isMagic(grid, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k) {

        int target = 0;
        for (int j = c; j < c + k; j++) {
            target += grid[r][j];
        }

        for (int i = r; i < r + k; i++) {
            int sum = 0;
            for (int j = c; j < c + k; j++) {
                sum += grid[i][j];
            }
            if (sum != target) return false;
        }

        for (int j = c; j < c + k; j++) {
            int sum = 0;
            for (int i = r; i < r + k; i++) {
                sum += grid[i][j];
            }
            if (sum != target) return false;
        }

        int diag1 = 0, diag2 = 0;
        for (int d = 0; d < k; d++) {
            diag1 += grid[r + d][c + d];
            diag2 += grid[r + d][c + k - 1 - d];
        }

        return diag1 == target && diag2 == target;
    }
}
