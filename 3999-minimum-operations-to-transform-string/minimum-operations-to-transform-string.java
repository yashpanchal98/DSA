class Solution {
    public int minOperations(String s) {
        int freq[] = new int[26];

        for(int ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        int ans = 0;
        for(int i=1; i<26; i++){
            if(freq[i]>0){
                ans = 26-i;
                break;
            }
        }
        return ans;
    }
}