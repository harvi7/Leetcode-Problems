// https://www.youtube.com/watch?v=rmxZp7tlT0g

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] A = new int[n * n + 2];
        int index = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    A[index] = dfs(grid, i, j, index++);
            }
        }

        boolean hasZero = false;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> set = new HashSet();
                    if (i > 0) set.add(grid[i - 1][j]);
                    if (j > 0) set.add(grid[i][j - 1]);
                    if (i < n - 1) set.add(grid[i + 1][j]);
                    if (j < n - 1) set.add(grid[i][j + 1]);

                    int area = 1;
                    for (int k : set)
                        area += A[k];

                    largest = Math.max(largest, area);
                }
            }
        }

        return hasZero ? largest : n * n;
    }

    private int dfs(int[][] grid, int x, int y, int color) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
            return 0;
        grid[x][y] = color;
        return 1 + dfs(grid, x + 1, y, color) +
                dfs(grid, x - 1, y, color) +
                dfs(grid, x, y + 1, color) +
                dfs(grid, x, y - 1, color);
    }
}