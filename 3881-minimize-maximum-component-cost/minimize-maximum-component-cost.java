class Solution {

    class DSU {
        int parent[];
        int rank[];

        public DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];

            for(int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if(parent[x] != x) {
                
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }

        public void union(int x, int y){
            
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return;

            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    public int minCost(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        ArrayList<Integer> list = new ArrayList<>();

        for(int edge[] : edges){
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            if(dsu.find(src) != dsu.find(dest)){
                dsu.union(src,dest);
                list.add(wt);
            }
        }

        for(int i=0; i<k-1; i++){
            list.remove(list.size()-1);
        }

        return list.isEmpty() ? 0 : list.get(list.size()-1);
        
    }
}