// https://www.youtube.com/watch?v=fyW6AeZkiYc

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (int[] a, int[] b) -> a[1] - b[1]
        );
        
        for(int[] edge : times){
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        
         int res = Integer.MIN_VALUE;
        Map<Integer,Integer> dist = new HashMap<>();
        pq.add(new int[]{K, 0});
        
        while(!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            
            if(dist.containsKey(node)) continue;
            dist.put(node, dis);
            res = Math.max(res, dis);
            if(graph.containsKey(node))
                for(int[] neighbor : graph.get(node)){

                    int neighborNode = neighbor[0]; 
                    int neighborDist = neighbor[1];

                    if(!dist.containsKey(neighborNode)){
                        pq.add(new int[]{neighborNode, neighborDist + dis});
                    }
                }
        }
   
        

        return dist.size() == N ? res : -1;
    }
}