// https://www.youtube.com/watch?v=hWFqtlbnQV8&list=PL1w8k37X_6L8xh476yG6UNfXBCT1tq2vM&index=28

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] groups = new int[N];
        Arrays.fill(groups, -1);
        
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList();
        
        for (int[] p : dislikes) {
            adj[p[0] - 1].add(p[1] - 1);
            adj[p[1] - 1].add(p[0] - 1);
        }
        for (int i = 0; i < N; i++) {
            if (groups[i] == -1 && !dfs(adj, groups, i, 0))
                return false;
        }
        return true;
    }
    
    private boolean dfs(ArrayList<Integer>[] adj, int[] groups, int v, int grp) {
        if (groups[v] == -1) groups[v] = grp;
        else return groups[v] == grp;
        
        for (int n : adj[v]) {
            if (!dfs(adj, groups, n, 1 - grp))
                return false;
        }
        return true;
    }
}