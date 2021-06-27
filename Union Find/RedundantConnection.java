// https://www.youtube.com/watch?v=xHd8p2BCxYo

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UF uf = new UF(n);
              
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return edge;
        }
        return null;
    }
}

class UF {
    int[] sub;
    public UF(int size) {
        sub = new int[size];
        for (int i = 0; i < size; i++) {
            sub[i] = i;
        }
    }
    
    int find (int x) {
        if (x != sub[x]){
            sub[x] = find(sub[x]);
        }
        return sub[x];
    }
    
    boolean union (int x, int y) {
        int xr = find(x); int yr = find(y);
        if (xr == yr)
        return false;
        
        sub[xr] = find(yr);
        return true;
    }
}