class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        int n = dimensions.length;
        int maxArea = 0, maxDiag = 0;

        for(int i=0; i<n; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];

            int diag = l*l+w*w;

            if(diag > maxDiag || (diag == maxDiag && l*w > maxArea)){
                maxDiag = diag;
                maxArea = l*w;
            }
        }   
        return maxArea;
    }
}