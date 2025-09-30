class Solution {

    public List<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int[] nums, int src, boolean[] isVis) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> comp = new ArrayList<>();
        q.add(src);
        isVis[src] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            comp.add(curr);
            for (int neigh : adj.get(curr)) {
                if (!isVis[neigh]) {
                    isVis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        return comp;
    }

    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] swap : swaps) {
            int u = swap[0], v = swap[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] isVis = new boolean[n];
        int[] arr = Arrays.copyOf(nums, n);

        for (int i = 0; i < n; i++) {
            if (!isVis[i]) {
                List<Integer> comp = bfs(adj, nums, i, isVis);
                Collections.sort(comp);
                List<Integer> values = new ArrayList<>();
                for (int idx : comp) values.add(nums[idx]);
                Collections.sort(values);

                int l = 0, r = values.size() - 1;
                for (int idx : comp) {
                    if (idx % 2 == 0) arr[idx] = values.get(r--);
                    else arr[idx] = values.get(l++);
                }
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) total += arr[i];
            else total -= arr[i];
        }
        return total;
    }
}