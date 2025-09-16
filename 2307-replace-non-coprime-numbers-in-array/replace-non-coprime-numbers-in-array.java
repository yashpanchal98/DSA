class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        Stack<Integer> st = new Stack<>();

        for (int num : nums) {
            st.push(num);

            while (st.size() > 1) {
                int a = st.pop();
                int b = st.pop();
                int g = gcd(a, b);

                if (g > 1) {
                    st.push(lcm(a, b)); 
                } else {
                    st.push(b);
                    st.push(a);
                    break; 
                }
            }
        }

        return new ArrayList<>(st);
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (int) ((long) a * b / gcd(a, b));
    }
}