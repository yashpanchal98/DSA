class Solution {

    class Pair implements Comparable<Pair> {
        int val;
        int freq;

        public Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
        public int compareTo(Pair i){
            return i.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int ans[] = new int[k];
        int idx =0;
        while(idx != k){
            ans[idx++] = pq.remove().val;
        }
        return ans;
    }
}