public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null;";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                sb.append("null;");
                continue;
            }
            sb.append(curr.val).append(";");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    String[] str = data.split(";");
    if (str[0].equals("null") || str[0].isEmpty()) return null;

    TreeNode root = new TreeNode(Integer.parseInt(str[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < str.length) {
        TreeNode curr = q.poll();
        if (curr == null) continue;

        // Left child
        if (i < str.length && !str[i].equals("null") && !str[i].isEmpty()) {
            curr.left = new TreeNode(Integer.parseInt(str[i]));
            q.add(curr.left);
        } else {
            curr.left = null;
            q.add(null);
        }
        i++;

        // Right child
        if (i < str.length && !str[i].equals("null") && !str[i].isEmpty()) {
            curr.right = new TreeNode(Integer.parseInt(str[i]));
            q.add(curr.right);
        } else {
            curr.right = null;
            q.add(null);
        }
        i++;
    }
    return root;
    }
}