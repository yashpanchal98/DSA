class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int n = tops.length;
        int top[] = new int[7];
        int bottom[] = new int[7];
        int same[] = new int[7];
        for (int i = 0; i < n; i++) {

            top[tops[i]]++;
            bottom[bottoms[i]]++;
            if (tops[i] == bottoms[i])
                same[tops[i]]++;

        }
        int ans = -1;

        for (int i = 0; i < 7; i++) {
            if (top[i] + bottom[i] - same[i] >= n) {
                ans = Math.min(top[i] - same[i], bottom[i] - same[i]);
            }
        }
        return ans;
    }
}