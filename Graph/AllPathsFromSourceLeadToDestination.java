// https://www.youtube.com/watch?v=ZlfXhtq_EFE

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0 && source == destination) return true;
        if (edges.length == 0 && source != destination) return false;
        
        List<Integer>[] g = new List[n];
        int[] colors = new int[n];
        buildGraph(g, edges);
        
        return dfs(g, source, destination, colors);
    }
    
    private boolean dfs(List<Integer>[] g, int s, int d, int[] colors) {
        if (g[s] == null || g[s].size() == 0) return s == d;

        colors[s] = 1;
        for (int next : g[s]) {
            if (colors[next] == 1) return false;
            if (colors[next] == 0 && !dfs(g, next, d, colors)) return false;
        }

        colors[s] = 2;
        return true;
    }
    
    private void buildGraph(List<Integer>[] g, int[][] edges) {
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            if (g[from] == null)
                g[from] = new LinkedList<>();
            
            g[from].add(to);
        }
    }
}