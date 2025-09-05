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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode link = curr.left;
                while(link.right != null && link.right != curr){
                    link = link.right;
                }

                if(link.right == null){
                    link.right = curr;
                    curr = curr.left;
                } else if(link.right == curr){
                    list.add(curr.val);
                    link.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}