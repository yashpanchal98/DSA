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

    public static void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    public boolean findTarget(TreeNode root, int k) {
        
        ArrayList<Integer> ans = inorderTraversal(root);
        int low = 0,high = ans.size()-1;
        while(low<high){
            int sum = ans.get(low)+ans.get(high);
            if(sum==k) return true;
            if(sum>k) high--;
            else low++;
        }
        return false;
    }
}