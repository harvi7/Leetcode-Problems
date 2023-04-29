class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void helper(int[][] image, int i, int j, int color, int newColor) {
        int m = image.length, n = image[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != color)
            return;
        image[i][j] = newColor;
        helper(image, i - 1, j, color, newColor);
        helper(image, i + 1, j, color, newColor);
        helper(image, i, j + 1, color, newColor);
        helper(image, i, j - 1, color, newColor);
    }
}