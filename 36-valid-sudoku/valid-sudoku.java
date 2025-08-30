class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    board[i][j] = '.';
                    if (!isSafe(board, i, j, currentValue)) {
                        return false;
                    }
                    board[i][j] = currentValue;
                }
            }
        }
        return true;
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}