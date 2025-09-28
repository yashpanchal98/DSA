class Solution {
    public int distinctPoints(String s, int k) {

        HashSet<String> hs = new HashSet<>();
        int n = s.length();

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'L') x--;
            else x++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            // cancelling the effect of right directions
            if (rightChar == 'U') y--;
            else if (rightChar == 'D') y++;
            else if (rightChar == 'L') x++;
            else x--;

            if (right - left + 1 > k) {
                // adding back the left pointer directions
                char leftChar = s.charAt(left);
                if (leftChar == 'U') y++;
                else if (leftChar == 'D') y--;
                else if (leftChar == 'L') x--;
                else x++;
                left++;
            }

            if (right - left + 1 == k) {
                hs.add(x + "," + y);
            }
        }
        return hs.size();
    }
}