class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<fruits.length; i++){
            map.put(fruits[i][0],fruits[i][1]);
        }

        int ans1 = goRightFirst(map, startPos, k);
        int ans2 = goLeftFirst(map, startPos, k);

        return Math.max(ans1, ans2);
    }

    private int goRightFirst(HashMap<Integer,Integer> map, int startPos, int k) {
        int left = 0;
        int right = startPos;
        int ans = 0, max = 0;

        left = 2*right - k - startPos;
        if(left < 0) left = 0;

        for(int i=left; i<=right; i++){
            if(map.containsKey(i)){
                ans += map.get(i);
            }
        }
        max = Math.max(max, ans);
        right++;

        while(right <= startPos + k){
            if(map.containsKey(right)) ans += map.get(right);

            while(left < 2*right - k - startPos){
                if(map.containsKey(left)) ans -= map.get(left);
                left++;
            }

            max = Math.max(max, ans);
            right++;
        }
        return max;
    }

    private int goLeftFirst(HashMap<Integer,Integer> map, int startPos, int k) {
        int left = startPos;
        int right = 0;
        int ans = 0, max = 0;

        right = 2*left + k - startPos;

        for(int i=left; i<=right; i++){
            if(map.containsKey(i)){
                ans += map.get(i);
            }
        }
        max = Math.max(max, ans);
        left--;

        while(left >= startPos - k){
            if(map.containsKey(left)) ans += map.get(left);

            while(right > 2*left + k - startPos){
                if(map.containsKey(right)) ans -= map.get(right);
                right--;
            }

            max = Math.max(max, ans);
            left--;
        }
        return max;
    }
}