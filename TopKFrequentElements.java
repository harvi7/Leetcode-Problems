class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap();
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> map.get(y) - map.get(x));
//         for(int i : nums)
//             map.put(i, map.getOrDefault(i,0) + 1);
//         for(int i : map.keySet())
//               pq.add(i);
//         List<Integer> res = new ArrayList();

//         for(int j = 0; j< k; j++)
//                  res.add(pq.poll());
//         return res;
        
        Map<Integer, Integer> dic = new HashMap<>();
        for(int num : nums) {
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((q1, q2)->q2[1]-q1[1]);
        for(int n : dic.keySet()) {
            queue.offer(new int[]{n, dic.get(n)});
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(queue.poll()[0]);
        }
        return res;
    }
}