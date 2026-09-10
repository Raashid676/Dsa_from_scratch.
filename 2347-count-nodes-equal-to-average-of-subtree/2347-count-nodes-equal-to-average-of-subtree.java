
class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns {sum, count}
    private int[] dfs(TreeNode root) {

        // empty subtree
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get information from left subtree
        int[] left = dfs(root.left);

        // Get information from right subtree
        int[] right = dfs(root.right);

        // Total sum of current subtree
        int sum = left[0] + right[0] + root.val;

        // Total number of nodes in current subtree
        int count = left[1] + right[1] + 1;

        // Average of current subtree
        int average = sum / count;

        // Check condition
        if (average == root.val) {
            ans++;
        }

        return new int[]{sum, count};
    }
}