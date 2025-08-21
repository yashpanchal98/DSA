class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int[] h = Arrays.copyOf(heights, n + 1);

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}