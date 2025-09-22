class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101]; 
        int maxfreq = 0;
        for(int num : nums) {
            freq[num]++;
            maxfreq = Math.max(maxfreq, freq[num]);
        }
        int ans = 0;
        for(int f : freq) {
            if(f == maxfreq) {
                ans += maxfreq;
            }
        }
        return ans;
    }
}