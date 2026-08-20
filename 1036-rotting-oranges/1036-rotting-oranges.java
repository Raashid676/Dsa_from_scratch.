
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {              // fixed: j<m, not j<n
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});         // fixed: wrap in array
                } else if (grid[i][j] == 1) {
                    cntFresh++;                          // fixed: count fresh oranges here
                }
            }
        }

        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int count = 0;                                   // rotted-during-BFS counter

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], t = curr[2];   // fixed: curr[1] not curr[i]
            tm = Math.max(tm, t);

            for (int d = 0; d < 4; d++) {
                int nr = r + drow[d];
                int nc = c + dcol[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    count++;                              // fixed: use declared 'count'
                    q.add(new int[]{nr, nc, t + 1});      // fixed: t+1 not ++1
                }
            }
        }

        return count != cntFresh ? -1 : tm;               // fixed: compare count vs cntFresh
    }
}