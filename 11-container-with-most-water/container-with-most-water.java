class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(right > left){

            int min = Math.min(height[right],height[left]);
            int area = (right-left)*min;
            ans = Math.max(ans,area);

            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}