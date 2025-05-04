class Solution {

    public void dfs(int row,int col, int m, int n, char grid[][],boolean vis[][]){

        if(row<0 || row >= m || col<0 || col>= n || vis[row][col] || grid[row][col]=='0'){
            return;
        }

        vis[row][col] = true;
        dfs(row+1,col,m,n,grid,vis);
        dfs(row-1,col,m,n,grid,vis);
        dfs(row,col+1,m,n,grid,vis);
        dfs(row,col-1,m,n,grid,vis);
    }

    public int numIslands(char[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, m, n, grid,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}