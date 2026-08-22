class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        for (int j = 0; j < m; j++) {

            // first row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delcol);
            }

            // last row
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {

            // first col
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delcol);
            }

            // last col
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delrow, delcol);
            }
        }

        // convert unvisited O to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(int row, int col, int vis[][], char mat[][], int delrow[], int delcol[]) {

        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        // check for top right bottom left
        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }
}