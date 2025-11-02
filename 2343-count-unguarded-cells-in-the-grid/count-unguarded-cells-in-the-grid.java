class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] mat = new char[m][n];
        int cnt = 0;

        for (int[] guard : guards) {
            mat[guard[0]][guard[1]] = 'G';
            cnt++;
        }
        for (int[] wall : walls) {
            mat[wall[0]][wall[1]] = 'W';
            cnt++;
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            // Up
            for (int r = row - 1; r >= 0; r--) {
                if (mat[r][col] == 'G' || mat[r][col] == 'W') break;
                if (mat[r][col] != 'O') {
                    mat[r][col] = 'O';
                    cnt++;
                }
            }

            // Down
            for (int r = row + 1; r < m; r++) {
                if (mat[r][col] == 'G' || mat[r][col] == 'W') break;
                if (mat[r][col] != 'O') {
                    mat[r][col] = 'O';
                    cnt++;
                }
            }

            // Left
            for (int c = col - 1; c >= 0; c--) {
                if (mat[row][c] == 'G' || mat[row][c] == 'W') break;
                if (mat[row][c] != 'O') {
                    mat[row][c] = 'O';
                    cnt++;
                }
            }

            // Right
            for (int c = col + 1; c < n; c++) {
                if (mat[row][c] == 'G' || mat[row][c] == 'W') break;
                if (mat[row][c] != 'O') {
                    mat[row][c] = 'O';
                    cnt++;
                }
            }
        }

        return m * n - cnt;
    }
}
