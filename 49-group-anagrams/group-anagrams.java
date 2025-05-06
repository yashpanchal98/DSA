class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        boolean vis[] = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if(vis[i]) continue;
            String word = strs[i];
            vis[i] = true;
            
            List<String> ans = new ArrayList<>();
            ans.add(word);

            for(int j=i+1; j<strs.length; j++){

                if(vis[j]) continue;

                int a1[] = new int[26];
                for(int a=0; a<word.length(); a++) a1[word.charAt(a)-'a']++;

                String newWord = strs[j];
                if(word.length() != newWord.length()) continue;
                boolean isFound = true;

                for(int k=0; k<newWord.length(); k++) a1[newWord.charAt(k)-'a']--;

                for(int k=0; k<26; k++){
                    if(a1[k] != 0){
                        isFound = false;
                        break;
                    }
                }
                if(isFound){
                    vis[j] = true;
                    ans.add(newWord);
                }
            }
            list.add(ans);
        }
        return list;
    }
}