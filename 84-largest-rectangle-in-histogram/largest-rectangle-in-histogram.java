class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();

        int n = heights.length;
        int nextSmaller[] = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) nextSmaller[i] = n;
            else nextSmaller[i] = st.peek();
            st.push(i);
            System.out.print(st.peek());
        }

        st.clear();

        int prevSmaller[] = new int[n];

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) prevSmaller[i] = -1;
            else prevSmaller[i] = st.peek();
            st.push(i);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int width = nextSmaller[i]-prevSmaller[i]-1;
            int ht = heights[i];

            ans = Math.max(ans,width*ht);
        }
        return ans;
    }
}