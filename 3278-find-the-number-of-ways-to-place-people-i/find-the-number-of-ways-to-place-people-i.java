class Solution {

    public boolean valid(int xi, int yi, int xf, int yf, int[][] points, int i, int j) {

        for (int k = 0; k < points.length; k++) {
            if (k == i || k == j) continue; 
            int xk = points[k][0];
            int yk = points[k][1];
            
            if (xi <= xk && xk <= xf && yf <= yk && yk <= yi) {
                return false; 
            }
        }
        return true;
    }

    public int numberOfPairs(int[][] points) {
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int cnt = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] >= points[j][1]) { 
                    if (valid(points[i][0], points[i][1], points[j][0], points[j][1], points, i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}