class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        
        // Next smaller
        int[] nxtSmall = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nxtSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        // Previous smaller
        int[] prevSmall = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            prevSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        // Next greater
        int[] nxtGreater = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nxtGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        // Previous greater
        int[] prevGreater = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long max = 0;
        long min = 0;

        for (int i = 0; i < n; i++) {
            // Calculate contribution as minimum
            long leftSmall = i - prevSmall[i];       
            long rightSmall = nxtSmall[i] - i;      
            min += (leftSmall * rightSmall) * (long)arr[i];
   
            long leftLarge = i - prevGreater[i];
            long rightLarge = nxtGreater[i] - i;
            max += (leftLarge * rightLarge) * (long)arr[i];
        }

        return max - min; 
    }
}