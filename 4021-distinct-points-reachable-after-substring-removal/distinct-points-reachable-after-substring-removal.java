class Solution {
    public int distinctPoints(String s, int k) {

        HashSet<String> hs = new HashSet<>();
        int n = s.length();

        int xO = 0, yO = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'U')
                yO++;
            else if (ch == 'D')
                yO--;
            else if (ch == 'L')
                xO--;
            else
                xO++;
        }

        int left = 0;
        int right;
        int x = xO, y = yO;
        // first window - cancelling the effect of dir
        for (right = 0; right < k; right++) {
            char ch = s.charAt(right);
            if (ch == 'U')
                y--;
            else if (ch == 'D')
                y++;
            else if (ch == 'L')
                x++;
            else
                x--;
        }
        hs.add(x + "," + y);

        while (right < n) {
            // adding the cancelled left effect
            char leftChar = s.charAt(left);
            if (leftChar == 'U')
                y++;
            else if (leftChar == 'D')
                y--;
            else if (leftChar == 'L')
                x--;
            else
                x++;
            
            // cancelling upcoming window effect
            char rightChar = s.charAt(right);
            if (rightChar == 'U')
                y--;
            else if (rightChar == 'D')
                y++;
            else if (rightChar == 'L')
                x++;
            else
                x--;
            
            hs.add(x + "," + y);
            
            left++;
            right++;
        }
        return hs.size();
    }
}