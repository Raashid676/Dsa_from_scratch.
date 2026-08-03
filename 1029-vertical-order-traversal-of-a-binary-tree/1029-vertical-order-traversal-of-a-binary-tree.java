import java.util.*;

class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            map.putIfAbsent(curr.col, new TreeMap<>());
            map.get(curr.col).putIfAbsent(curr.row, new PriorityQueue<>());
            map.get(curr.col).get(curr.row).offer(curr.node.val);

            if (curr.node.left != null) {
                q.offer(new Pair(curr.node.left, curr.row + 1, curr.col - 1));
            }

            if (curr.node.right != null) {
                q.offer(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}