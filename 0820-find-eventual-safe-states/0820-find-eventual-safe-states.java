class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList <>());
        }

        int inDeg [] = new int [V];
        for(int i=0; i<V; i++){

            for(int it: graph[i]){
                adjRev.get(it).add(i);
                inDeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<V; i++){

            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int node = q.peek();
            q.remove();
            safeNodes.add(node);


            for(int it: adjRev.get(node)){
                inDeg[it]--;

                if(inDeg[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);


        return safeNodes;
        
    }
}