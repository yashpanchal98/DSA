class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>(); 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new PriorityQueue<>());
                map.get(key).add(mat[i][j]);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = map.get(i-j).remove();
            }
        }
        return mat;
    }
}