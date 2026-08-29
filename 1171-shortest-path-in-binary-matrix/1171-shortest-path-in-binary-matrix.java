class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        if(n == 1) return 1;


        // 8 possible directions (including diagonals)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        boolean[][] visited  = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int pathLen = 1;

        while(!q.isEmpty()){
            int size = q.size();


            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                // Reached the bottom right cell

                if(row == n-1 && col == n-1){
                    return pathLen;
                }

                // explore all 8 neighbors

                for(int[] dir: directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];


                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol] &&  grid[newRow][newCol] == 0){

                        visited[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            pathLen++;
        }

        return -1;
        
    }
}