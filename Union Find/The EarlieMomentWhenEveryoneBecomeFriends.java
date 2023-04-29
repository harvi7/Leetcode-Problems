// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/discuss/1274520/Java-simple-union-find-with-explanation

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        UF uf = new UF(n);

        int connections = 0;
        for (int[] log: logs) {
            boolean u = uf.union(log[1], log[2]);
            if (u) {
                if(++connections == n - 1) return log[0];
            }
        }
        
        return -1;
    }
    
    private class UF {
        private int[] parents;
        private int[] weights;
        
        public UF(int n) {
            this.parents = new int[n];
            this.weights = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                weights[i] = 1;
            }
        }
        
        public int find(int a) {
            while(a != parents[a]) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }
        
        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if(rootA == rootB) return false;
            if(weights[rootA] >= weights[rootB]) {
                parents[rootB] = rootA;
                weights[rootA] += weights[rootB];
            } else {
                parents[rootA] = rootB;
                weights[rootB] += weights[rootA];
            }
            return true;
        }
    }
}