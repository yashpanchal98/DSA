import java.util.LinkedList;
import java.util.Queue;

// Assuming TreeNode class is defined as provided in the problem
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {

    class Pair {
        TreeNode node;
        int idx;

        public Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0)); 

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();

            int minIdx = q.peek().idx; 
            int maxIdx = -1; 

            for(int i = 0; i < size; i++){
                Pair curr = q.remove();
                maxIdx = curr.idx;

                if(curr.node.left != null){
                    q.add(new Pair(curr.node.left, 2 * curr.idx + 1));
                }
                if(curr.node.right != null){
                    q.add(new Pair(curr.node.right, 2 * curr.idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, maxIdx - minIdx + 1);
        }
        return maxWidth;
    }
}