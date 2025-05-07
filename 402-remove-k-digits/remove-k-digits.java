class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            int ch = num.charAt(i) - '0';
            if (st.isEmpty() || k == 0) {
                st.push(ch);
            } else if (st.peek() <= ch) {
                st.push(ch);
            } else {
                while (!st.isEmpty() && st.peek() > ch && k > 0) {
                    k--;
                    st.pop();
                }
                st.push(ch);
            }

        }
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        if(sb.length() == 0) sb.append("0");
        return sb.toString();
    }
}