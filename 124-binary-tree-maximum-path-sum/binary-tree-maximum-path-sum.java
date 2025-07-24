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
    int maxSum = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        if(left<0) left = 0;
        int right = helper(root.right);
        if(right<0) right = 0;

        int currPathSum = left + right + root.val;
        maxSum = Math.max(maxSum, currPathSum);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
}
