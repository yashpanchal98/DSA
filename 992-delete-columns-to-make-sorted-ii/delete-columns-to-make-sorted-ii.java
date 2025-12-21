class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int m = strs[0].length();
        boolean valid[] = new boolean[n];
        int ans = 0;

        for(int j=0; j<m; j++){
            
            boolean found = false;
            for(int i=0; i<n-1; i++){

                if(!valid[i] && strs[i].charAt(j) > strs[i+1].charAt(j)){
                    found = true;
                    break;
                }
            }

            if(found){
                ans++;
                continue;
            }

            for(int i=0; i<n-1; i++){

                if(strs[i].charAt(j) < strs[i+1].charAt(j)){
                    valid[i] = true;
                }
            }
        }
        return ans;
    }
}