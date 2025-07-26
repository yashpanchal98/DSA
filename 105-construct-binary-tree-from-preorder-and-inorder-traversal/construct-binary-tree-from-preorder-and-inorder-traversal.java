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

    int idx = 0; 

    TreeNode solve(int[] preorder , int[] inorder , int left , int right ) {

        if(left > right) return null;
        
        int rootNode = preorder[idx++];
        int i = left;

        for( i = left ; i<right ; i++) {
            if(inorder[i] == rootNode) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootNode);

        root.left = solve(preorder , inorder , left , i-1 );
        root.right = solve(preorder , inorder , i+1 , right );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        return solve(preorder , inorder , 0 , n-1 );
    }
}
