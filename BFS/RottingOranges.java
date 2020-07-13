// https://www.youtube.com/watch?v=TzoDDOj60zE

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        List<int[]> rotten = new ArrayList();
        int fresh = 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2) rotten.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (rotten.size() > 0) {
            List<int[]> temp = new ArrayList();
            for(int[] coor : rotten){
                int i = coor[0], j = coor[1];
                for (int[] direction: directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (nextI >=0 && nextI < grid.length && nextJ >=0 && nextJ <grid[0].length && grid[nextI][nextJ] == 1) {
                        temp.add(new int[]{nextI,nextJ});
                        grid[nextI][nextJ]=2;
                        fresh--;
                    }
                }
            }
            rotten=temp;
            ans++;
        }
        if(fresh>0) return -1;
        return --ans;
    }
}