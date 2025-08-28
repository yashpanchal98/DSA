class Solution {

    public int countRect(int arr[]){

        int cons = 0;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1) cons++;
            else cons=0;
            ans+=cons;
        }
        return ans;
    }

    public int numSubmat(int[][] mat) {
        
        int startRow = 0, endRow = 0;
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        for(startRow = 0; startRow <n ; startRow++){

            int arr[] = mat[startRow];

            for(endRow = startRow; endRow<n ; endRow++){

                for(int i=0; i<m; i++){
                    if(arr[i]== 1 && mat[endRow][i] == 1) arr[i] = 1;
                    else arr[i] = 0;
                }  

                ans += countRect(arr);
            }

        }
        return ans;
    }
}