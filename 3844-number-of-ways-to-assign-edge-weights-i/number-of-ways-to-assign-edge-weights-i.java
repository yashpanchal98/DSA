class Solution {

    private int dfs(int node, int depth, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        int maxDepth = depth;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                maxDepth = Math.max(maxDepth, dfs(neighbor, depth + 1, visited, adj));
            }
        }
        return maxDepth;
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod); 
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1; 

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1]; 
        int maxDepth = dfs(1, 0, visited, adj); 

        if (maxDepth == 0) return 0;

        final int MOD = 1_000_000_007;
        long totalWays = modPow(2, maxDepth, MOD);
        long result = (totalWays * modInverse(2, MOD)) % MOD;
        return (int) result;
    }
}