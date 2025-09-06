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

    static int index = 0;
    public TreeNode helper(int[] preorder,int[] inorder,int start, int end,HashMap<Integer,Integer> map){

        if(start > end) return null;

        int node = preorder[index++];
        TreeNode root = new TreeNode(node);

        int inorderIdx = map.get(node);

        root.left = helper(preorder,inorder,start,inorderIdx-1,map);
        root.right = helper(preorder,inorder,inorderIdx+1,end,map);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        index = 0;
        return helper(preorder,inorder,0,preorder.length-1,map);
    }
}