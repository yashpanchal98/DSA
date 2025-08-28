class Solution {
    public int[][] sortMatrix(int[][] grid) {
        
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                int key = i-j;
                if(key>=0) map.putIfAbsent(key,new PriorityQueue<>((a,b)-> b-a));
                else map.putIfAbsent(key,new PriorityQueue<>());
                map.get(key).add(grid[i][j]);
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j] = map.get(i-j).remove();
            }
        }
        return grid;
    }
}