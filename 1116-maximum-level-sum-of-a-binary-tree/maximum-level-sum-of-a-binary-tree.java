class Solution {
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currLevel = 0;

        while (!q.isEmpty()) {

            int sz = q.size();
            int sum = 0;
            currLevel++;

            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = currLevel;
            }
        }

        return maxLevel;
    }
}
