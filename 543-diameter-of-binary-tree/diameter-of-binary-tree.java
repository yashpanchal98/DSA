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

    int diameter = 0;

    public int height(TreeNode root){

        if(root == null) return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        diameter = Math.max(diameter,leftH+rightH);
        return Math.max(leftH,rightH)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
       int ans = height(root);
       return diameter;
    }
}