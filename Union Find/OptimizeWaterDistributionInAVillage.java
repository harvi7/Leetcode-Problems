// https://www.youtube.com/watch?v=7-udoMWSyW8
// https://leetcode.com/problems/optimize-water-distribution-in-a-village/solution/

class Solution {
    class DSU {
        // int count;
        int[] size; // union by rank
        int[] root; // path compression

        public DSU(int n) {
            size = new int[n + 1];
            root = new int[n + 1];
            Arrays.fill(size, 1);

            for (int i = 1; i <= n; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }

            return root[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY) return false;
            if (size[rootX] < size[rootY]) {
                root[rootX] = rootY;
                size[rootY] += size[rootX]; // size[rootY]++;
            } else {
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }

            return true;
        }
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        DSU dsu = new DSU(n);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < wells.length; i++) {
            heap.offer(new int[]{0, i + 1, wells[i]});
        }

        for (int[] p : pipes) {
            heap.offer(p);
        }

        int res = 0;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            if (dsu.union(cur[0], cur[1])) {
                res += cur[2];
            }
        }

        return res;
    }
}