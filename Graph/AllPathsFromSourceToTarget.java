// https://www.youtube.com/watch?v=SZ3zpzQk2jg

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        dfs(graph, result, new ArrayList(), 0);
        return result;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int u){
        path.add(u);
        if (u == graph.length-1) 
            result.add(new ArrayList(path));
        else 
            for (int v: graph[u]) 
                dfs(graph, result, path, v);
        path.remove(path.size() - 1);
    }
}