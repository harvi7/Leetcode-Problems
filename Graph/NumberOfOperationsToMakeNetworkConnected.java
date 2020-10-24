// https://www.youtube.com/watch?v=3JIwIRir2sM

class Solution {
    public int makeConnected(int n, int[][] connections) {        
        boolean visited[] = new boolean[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }
      
        for (int connection[] : connections) {
            adj[connection[0]].add(connection[1]);
            adj[connection[1]].add(connection[0]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] !=true) {
                components++;
                dfs(i, visited, adj);
            }
        }
        return connections.length >= n - 1 ? components - 1 : -1;
    }
    
    public void dfs(int n,boolean visited[],ArrayList<Integer>[] adj) {
        if (visited[n] != true) {
            visited[n] = true;
            for(int a : adj[n]) {
                if(visited[a] != true) {
                    dfs(a, visited, adj);
                }
            }
        }
    }
}