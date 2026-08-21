class Solution {

    private boolean dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] =1;

        for(int adjacentNode : adj.get(node)){

            if(vis[adjacentNode] == 1) return true;

            else if (vis[adjacentNode] == 0){
                if (dfs(adjacentNode, vis, adj)) return true;
            }
        }
        vis[node] = 2;

        return false;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int [] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int vis[] = new int [numCourses];
        for (int i=0; i<numCourses; i++){

            if(vis[i] == 0){
                if(dfs (i, vis, adj)) return false;
            }
        }

        return true;
        
    }
}