class Solution {

    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nxtSmall = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nxtSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        int[] prevSmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            prevSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevSmall[i];       
            long right = nxtSmall[i] - i;      
            long contribution = (left * right % mod) * arr[i] % mod; 
            sum = (sum + contribution) % mod;  
        }

        return (int) sum;
    }
}