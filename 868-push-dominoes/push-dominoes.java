class Solution {
    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        int[] rightF = new int[n];
        Arrays.fill(rightF, -1);

        int idx = -1;
        // Calculate right forces
        for (int i = 0; i < n; i++) {
            char ch = dominoes.charAt(i);
            if (ch == 'R')  idx = i;
            else if (ch == 'L') idx = -1;
            else if (idx != -1) rightF[i] = i - idx;
        }

        int[] leftF = new int[n];
        Arrays.fill(leftF, -1);
        idx = -1;
        // Calculate left forces
        for (int i = n - 1; i >= 0; i--) {
            char ch = dominoes.charAt(i);
            if (ch == 'L') idx = i;
            else if (ch == 'R') idx = -1;
            else if (idx != -1)   leftF[i] = idx - i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (rightF[i] == -1 && leftF[i] == -1) sb.append(dominoes.charAt(i));
            else if (rightF[i] == -1) sb.append('L');
            else if (leftF[i] == -1) sb.append('R');
            else if (rightF[i] == leftF[i]) sb.append('.');
            else if (rightF[i] < leftF[i]) sb.append('R');
            else  sb.append('L');
        }

        return sb.toString();
    }
}