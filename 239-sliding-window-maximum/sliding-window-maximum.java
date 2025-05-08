class Solution {

    class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p){
            return p.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int left = 0;
        int right = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(right = 0; right<k; right++){
            pq.add(new Pair(nums[right],right));
        }

        int ans[] = new int[n-k+1];
        int idx = 0;
        ans[idx++] = pq.peek().val;

        while(right < n){

            left++;
            while (!pq.isEmpty() && pq.peek().idx < left) {
                pq.remove();
            }
            pq.add(new Pair(nums[right], right));
            ans[idx++] = pq.peek().val;
            right++;
        }
        return ans;
    }
}