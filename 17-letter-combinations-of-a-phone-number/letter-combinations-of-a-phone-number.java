import java.util.*;

class Solution {

    public void helper(Map<Integer, String> map, String digits, int idx, StringBuilder str, List<String> result) {

        //  bc
        if (idx == digits.length()) {
            result.add(str.toString());
            return;
        }

        String letter = map.get(digits.charAt(idx) - '0');

        for (int i = 0; i < letter.length(); i++) {
            str.append(letter.charAt(i));
            helper(map, digits, idx + 1, str, result);
            str.deleteCharAt(str.length() - 1); 
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        helper(map, digits, 0, new StringBuilder(), result);
        return result;
    }
}