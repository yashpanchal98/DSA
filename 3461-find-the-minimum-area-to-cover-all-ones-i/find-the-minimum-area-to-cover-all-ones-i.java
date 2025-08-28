class Solution {
    public int minimumArea(int[][] grid) {
     
        int n = grid.length;
        int m = grid[0].length;
        
        int minRow=n,maxRow=-1;
        int minCol=m,maxCol=-1;
        boolean isFound = false;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(grid[i][j]==1){
                    isFound = true;
                    
                    minRow = Math.min(i,minRow);
                    minCol = Math.min(j,minCol);
                    maxRow = Math.max(i,maxRow);
                    maxCol = Math.max(j,maxCol);
                }
            }
        }
        if(isFound == false) return 0;
        
        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }
}