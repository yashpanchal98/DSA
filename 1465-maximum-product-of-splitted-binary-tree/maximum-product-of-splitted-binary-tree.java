class Solution {

    long maxProduct = 0;
    long MOD = 1_000_000_007;

    public long totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    public long pathSum(TreeNode root, long total) {
        if (root == null) return 0;

        long left = pathSum(root.left, total);
        long right = pathSum(root.right, total);

        long subTreeSum = left + right + root.val;
        maxProduct = Math.max(maxProduct, subTreeSum * (total - subTreeSum));

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        long total = totalSum(root);
        pathSum(root, total);
        return (int)(maxProduct % MOD);
    }
}