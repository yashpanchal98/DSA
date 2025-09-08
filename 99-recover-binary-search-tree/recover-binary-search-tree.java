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

    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public TreeNode find(TreeNode root, int k) {
        if (root == null) return null;
        if (root.val == k) return root;
        TreeNode left = find(root.left, k);
        if (left != null) return left;
        return find(root.right, k);
    }

    public void recoverTree(TreeNode root) {

        List<Integer> list2 = new ArrayList<>();
        inorder(list2, root);
        List<Integer> list1 = new ArrayList<>(list2);
        Collections.sort(list1);

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                TreeNode node1 = find(root, list1.get(i));
                TreeNode node2 = find(root, list2.get(i));
                int temp = node1.val;
                node1.val = node2.val;
                node2.val = temp;
                break;
            }
        }
    }
}