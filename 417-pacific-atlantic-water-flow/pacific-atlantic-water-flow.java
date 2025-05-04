class Solution {

    class Info {
        int row;
        int col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int[][] heights, int row, int col, boolean[][] vis) {
        int[] dirR = {0, 0, -1, 1};
        int[] dirC = {-1, 1, 0, 0};

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Info curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = curr.row + dirR[i];
                int newC = curr.col + dirC[i];

                if (newR >= 0 && newC >= 0 && newR < heights.length && newC < heights[0].length &&
                    !vis[newR][newC] &&
                    heights[newR][newC] >= heights[curr.row][curr.col]) {

                    q.offer(new Info(newR, newC));
                    vis[newR][newC] = true;
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] vis = new boolean[n][m];   // Pacific
        boolean[][] vis2 = new boolean[n][m];  // Atlantic

        // For Pacific Ocean
        for (int i = 0; i < m; i++) {
            if (!vis[0][i]) {
                bfs(heights, 0, i, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i][0]) {
                bfs(heights, i, 0, vis);
            }
        }

        // For Atlantic Ocean
        for (int i = 0; i < m; i++) {
            if (!vis2[n - 1][i]) {
                bfs(heights, n - 1, i, vis2); 
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis2[i][m - 1]) {
                bfs(heights, i, m - 1, vis2); 
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] && vis2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}