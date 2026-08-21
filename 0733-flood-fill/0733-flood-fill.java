class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        // If the color is already the same, do nothing
        if (oldColor == color) {
            return image;
        }

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int color) {

        // Out of bounds
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length) {
            return;
        }

        // Not the original color
        if (image[r][c] != oldColor) {
            return;
        }

        // Change the color
        image[r][c] = color;

        // 4 directions
        dfs(image, r + 1, c, oldColor, color); // down
        dfs(image, r - 1, c, oldColor, color); // up
        dfs(image, r, c + 1, oldColor, color); // right
        dfs(image, r, c - 1, oldColor, color); // left
    }
}