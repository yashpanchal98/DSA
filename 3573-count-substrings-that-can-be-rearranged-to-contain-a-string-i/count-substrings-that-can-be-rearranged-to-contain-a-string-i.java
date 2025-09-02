class Solution {
    public long validSubstringCount(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        if (m > n) return 0;

        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        long cnt = 0;                 
        int required = map2.size();   
        int valid = 0;                
        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch = word1.charAt(right);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

            if (map2.containsKey(ch) && map1.get(ch).intValue() == map2.get(ch).intValue()) {
                valid++;
            }

            while (valid == required) {
                cnt += (n - right);
                char leftChar = word1.charAt(left);
                map1.put(leftChar, map1.get(leftChar) - 1);

                if (map2.containsKey(leftChar) && map1.get(leftChar) < map2.get(leftChar)) {
                    valid--;
                }
                left++;
            }
        }

        return cnt;
    }
}