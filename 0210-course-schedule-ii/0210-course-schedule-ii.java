class Solution {

    private boolean dfsCheck(int node,
                              ArrayList<ArrayList<Integer>> adj,
                              int vis[], int pathVis[],
                              Stack<Integer> st) {

        vis[node] = 1;
        pathVis[node] = 1;

        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, st) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        st.push(node);
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V,
                             ArrayList<ArrayList<Integer>> adj,
                             Stack<Integer> st) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis, st) == true) return true;
            }
        }
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // build adjacency list: prereq -> course
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }

        Stack<Integer> st = new Stack<>();

        if (isCyclic(numCourses, adj, st) == true) {
            // cycle found, no valid order possible
            return new int[0];
        }

        int result[] = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            result[idx++] = st.pop();
        }

        return result;
    }
}