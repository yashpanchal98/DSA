class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int waterStored = 0;

        int leftH[] = new int[n];
        leftH[0] = height[0];
        for(int i=1; i<n; i++){
            leftH[i] = Math.max(leftH[i-1],height[i]);
        } 
        
        int rightMax = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax = Math.max(rightMax,height[i]);
            waterStored += Math.min(rightMax,leftH[i]) - height[i];
        }
        return waterStored;
    }
}