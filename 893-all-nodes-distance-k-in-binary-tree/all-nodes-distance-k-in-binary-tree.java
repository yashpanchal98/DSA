/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    class Pair{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public void buildGraph(TreeNode root,TreeNode par,HashMap<Integer,ArrayList<Integer>> graph){

        if(root == null) return;

        if(!graph.containsKey(root.val)) graph.put(root.val, new ArrayList<>());
        
        if(par != null){
            graph.get(par.val).add(root.val);
            graph.get(root.val).add(par.val);
        }

        buildGraph(root.left,root,graph);
        buildGraph(root.right,root,graph);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(target.val);

        buildGraph(root,null,graph);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target.val,0));

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size; i++){

                Pair curr = q.remove();
                if(curr.dist == k) ans.add(curr.node);

                List<Integer> list = graph.get(curr.node);

                for(int j=0; j<list.size(); j++){
                    if(!hs.contains(list.get(j))){
                        q.add(new Pair(list.get(j),curr.dist+1));
                        hs.add(list.get(j));
                    }
                }
            }
        }
        return ans;

    }
}