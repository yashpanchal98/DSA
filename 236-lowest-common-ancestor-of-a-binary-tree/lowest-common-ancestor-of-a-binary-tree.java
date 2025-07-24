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

    public boolean helper(TreeNode root, TreeNode node, List<TreeNode> path) {

        if(root == null) return false;
        path.add(root);

        if(root.val == node.val) return true;
    
        boolean left = helper(root.left,node,path);
        boolean right = helper(root.right,node,path);

        if(left || right) return true;
        path.remove(path.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        helper(root,p,path1);
        helper(root,q,path2);

        TreeNode lca = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i).val == path2.get(i).val) lca = path1.get(i);
            else break;   
        }
        return lca;
    }
}