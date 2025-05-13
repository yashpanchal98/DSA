class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        int n = s.length();
        int[] freq = new int[26];
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 1; i <= t; i++) {
            int zCount = freq[25]; 

            for (int f = 25; f > 0; f--) {
                freq[f] = freq[f - 1] % mod;
            }
            freq[0] = (zCount) % mod;
            freq[1] = (freq[1] + zCount) % mod;
        }

        int count = 0;
        for(int i=0;i<26; i++){
            count= (count+freq[i])%mod;
        }

        return count;
    }
}