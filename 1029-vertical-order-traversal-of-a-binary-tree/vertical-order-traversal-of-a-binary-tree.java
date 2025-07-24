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

    class Info {

        int hd;
        int level;
        TreeNode node;

        public Info(int hd, int level, TreeNode node) {
            this.hd = hd;
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<Info> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, HashMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(0, 0, root));

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Info curr = q.remove();

                map
                    .computeIfAbsent(curr.hd, k -> new HashMap<>())
                    .computeIfAbsent(curr.level, k -> new PriorityQueue<>())
                    .add(curr.node.val);

                if (curr.node.left != null) {
                    q.add(new Info(curr.hd - 1, curr.level + 1, curr.node.left));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.hd + 1, curr.level + 1, curr.node.right));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            List<Integer> temp = new ArrayList<>();
            if (!map.containsKey(i))
                continue;

            HashMap<Integer, PriorityQueue<Integer>> levelMap = map.get(i);

            List<Integer> sortedLevels = new ArrayList<>(levelMap.keySet());
            Collections.sort(sortedLevels);

            for (int level : sortedLevels) {
                PriorityQueue<Integer> pq = levelMap.get(level);
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            ans.add(temp);
        }
        return ans;
    }
}