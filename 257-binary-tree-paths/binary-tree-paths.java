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

    public void helper(TreeNode root, StringBuilder sb, List<String> str) {
        if (root == null) return;

        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            str.add(sb.toString());
        } else {
            sb.append("->");
            helper(root.left, sb, str);
            helper(root.right, sb, str);
        }

        sb.setLength(len); 
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> str = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, str);
        return str;
    }
}