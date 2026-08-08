public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if (currNode == null) {
                s.append("#,");
            } else {
                s.append(currNode.val).append(",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }

        return s.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();

            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }

            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}