// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/451796/Java-Straightforward-BFS-O(MNK)-time-or-O(MNK)-space

class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r == rows - 1 && c == cols - 1){
                    return res;
                }
                for (int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols){
                        if (grid[nextR][nextC] == 1)
                            nextK++;
                        if(nextK <= k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }                
            }
            res++;
        }
        return -1;
    }
}