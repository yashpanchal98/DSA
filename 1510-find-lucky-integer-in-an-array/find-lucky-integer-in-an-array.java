class Solution {
    public int findLucky(int[] arr) {
        
        int freq[] = new int[501];
        for(int elem : arr){
            freq[elem]++;
        }
        int ans = -1;
        freq[0] = -1;

        for(int i=0; i<freq.length; i++){
            if(i==freq[i]) ans = Math.max(ans,i);
        }
        return ans;
    }
}