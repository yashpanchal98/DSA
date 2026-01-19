class Solution {

    public boolean canFound(int[][] rowPrefix, int threshold, int mid) {

        int rows = rowPrefix.length;
        int cols = rowPrefix[0].length - 1;

        for (int r = mid - 1; r < rows; r++) {
            for (int c = mid - 1; c < cols; c++) {

                int sum = 0;

                for (int t = r - mid + 1; t <= r; t++) {
                    sum += rowPrefix[t][c + 1] - rowPrefix[t][c - mid + 1];
                    if (sum > threshold) {
                        break;
                    }
                }

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] rowPrefix = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + mat[i][j];
            }
        }

        int low = 1;
        int high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFound(rowPrefix, threshold, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}