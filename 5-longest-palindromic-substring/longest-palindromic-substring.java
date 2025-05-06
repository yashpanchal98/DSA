public class Solution {
    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String ans = "";

        for (int mid = 0; mid < s.length(); mid++) {
            
            // Odd-length palindrome
            int low = mid, high = mid;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > ans.length()) {
                    ans = s.substring(low, high + 1);
                }
                low--;
                high++;
            }

            // Even-length palindrome
            low = mid;
            high = mid + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > ans.length()) {
                    ans = s.substring(low, high + 1);
                }
                low--;
                high++;
            }
        }

        return ans;
    }
}