/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // Morris order Traversal
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();

        while(curr != null){

            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            } 

            else {
                TreeNode link = curr.left;
                while(link.right != null && link.right != curr){
                    link = link.right;
                }
                if(link.right == null){
                    list.add(curr.val);
                    link.right = curr;
                    curr = curr.left;
                } else if(link.right == curr){
                    link.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}