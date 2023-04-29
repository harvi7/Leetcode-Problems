// https://leetcode.com/problems/parallel-courses/solution/
// https://leetcode.com/problems/parallel-courses/discuss/344808/Java-Topological-Sort-%2B-BFS-w-comment-and-analysis.

// class Solution {
//     public int minimumSemesters(int n, int[][] relations) {
//         Map<Integer, List<Integer>> g = new HashMap<>(); 
//         int[] inDegree = new int[n + 1]; 
//         for (int[] r : relations) {
//             g.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); 
//             ++inDegree[r[1]]; 
//         }
//         Queue<Integer> q = new LinkedList<>(); 
//         for (int i = 1; i <= n; ++i)
//             if (inDegree[i] == 0)
//                 q.offer(i);
//         int semester = 0;
//         while (!q.isEmpty()) { 
//             for (int sz = q.size(); sz > 0; --sz) { 
//                 int c = q.poll();
//                 --n;
//                 if (!g.containsKey(c)) continue;
//                 for (int course : g.remove(c))
//                     if (--inDegree[course] == 0) 
//                         q.offer(course); 
//             }
//             ++semester; 
//         }
//         return n == 0 ? semester : -1;
//     }
// }

class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
        }
        int[] visited = new int[N + 1];

        int maxLength = 1;
        for (int node = 1; node < N + 1; node++) {
            int length = dfs(node, graph, visited);
            // we meet a cycle!
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private int dfs(int node, List<List<Integer>> graph, int[] visited) {
        // return the longest path (inclusive)
        if (visited[node] != 0) {
            return visited[node];
        } else {
            // mark as visiting
            visited[node] = -1;
        }
        int maxLength = 1;
        for (int endNode : graph.get(node)) {
            int length = dfs(endNode, graph, visited);
            // we meet a cycle!
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length + 1, maxLength);
        }
        // mark as visited
        visited[node] = maxLength;
        return maxLength;
    }
}