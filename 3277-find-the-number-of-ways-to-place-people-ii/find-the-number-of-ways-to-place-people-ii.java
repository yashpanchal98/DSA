class Solution {

    public int numberOfPairs(int[][] points) {
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int cnt = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int minY = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] >= points[j][1]) { 
                    if(minY < points[j][1]){
                        cnt++;
                        minY = points[j][1];
                    }
                }
            }
        }
        return cnt;
    }
}