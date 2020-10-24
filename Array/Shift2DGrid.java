// https://leetcode.com/problems/shift-2d-grid/discuss/431102/JavaPython-3-2-simple-codes-using-mod-space-O(1).

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length; 
        int start = m * n - k % (m * n);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i < m * n + start; ++i) {
            int j = i % (m * n), r = j / n, c = j % n;
            if ((i - start) % n == 0)
                ans.add(new ArrayList<>());
            ans.peekLast().add(grid[r][c]);
        }
        return ans;
    }
}