class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        int[] delrow = {-1, 0, 1, 0};   // was: int delrow = {...}
        int[] delcol = {0, 1, 0, -1};   // was: int delcol = {...}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int diff = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    // was: height[...][...]  ->  heights[...][...]

                    if (newEffort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newEffort;
                        pq.add(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }
        return 0;
    }
}