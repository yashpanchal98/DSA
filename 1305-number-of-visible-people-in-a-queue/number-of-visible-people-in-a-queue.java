class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int count = 0;

        int[] nxtGreater = new int[n];
        nxtGreater[n-1] = 0;
        st.push(n-1);
        for (int i = n - 2; i >= 0; i--) {
            count=0;
            while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
                count++;
            }
            if(!st.isEmpty()) count++;
            nxtGreater[i] = count;
            st.push(i);
        }
        return nxtGreater;
    }
}