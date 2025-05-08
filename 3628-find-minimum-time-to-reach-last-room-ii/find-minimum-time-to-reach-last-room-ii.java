class Solution {

    class Info implements Comparable<Info>{
        int row;
        int col;
        int time;
        int moves;
        
        public Info(int row, int col, int time, int moves) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.moves = moves;
        }

        public int compareTo(Info i){
            return this.time - i.time;
        }
    }
    
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Info> pq = new PriorityQueue<>();
        
        pq.add(new Info(0, 0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {

            Info curr = pq.remove();
            
            if (curr.row == n - 1 && curr.col == m - 1) {
                return curr.time;
            }
            for (int i = 0; i < 4; i++) {
                int newR = curr.row + dirR[i];
                int newC = curr.col + dirC[i];
                
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && !visited[newR][newC]) {
                    
                    visited[newR][newC] = true;
                    int waitingTime = Math.max(curr.time, moveTime[newR][newC]);
                    int travel = (curr.moves % 2 == 0) ? 1 : 2;
                    
                    pq.add(new Info(newR, newC, waitingTime+travel, curr.moves+1));
                }
            }
        }
        return -1; 
    }
}