class Solution {
    public int totalFruit(int[] fruits) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0,right = 0;
        int n = fruits.length;
        int len = 0;
        while(right < n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            while(map.size() > 2){

                int freq = map.get(fruits[left]);
                if(freq==1) map.remove(fruits[left]);
                else map.put(fruits[left],freq-1);
                left++;
            }
            len = Math.max(right-left+1,len);
            right++;
        }
        return len;
    }
}