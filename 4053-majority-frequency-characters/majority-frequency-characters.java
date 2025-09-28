class Solution {
    public String majorityFrequencyGroup(String s) {

        int freq[] = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }

        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            if(freq[i]==0) continue;
            map.put(freq[i],map.getOrDefault(freq[i],0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)>maxCount){
                maxCount = map.get(key);
                maxFreq = key;
            } else if(map.get(key)==maxCount){
                maxFreq = key;
            }
        }

        String str = "";
        for(int i=0; i<26; i++){
            if(freq[i]==maxFreq){
                str+=(char)(i+'a');
            }
        }
        return str;
    }
}