//https://leetcode.com/problems/minimum-height-trees/discuss/573561/Fast-and-Simple-recursive-JAVA-solution-with-Explanation
// https://leetcode.com/problems/minimum-height-trees/discuss/76055/share-some-thoughts

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) 
            map.put(i, new ArrayList<>());
        
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        for (int i = 0; i < n; i++)
            if (map.get(i).size() == 1) leaves.add(i);

        return prone(map, leaves);
    }
    
    private List<Integer> prone(Map<Integer, List<Integer>> map, List<Integer> leaves) {
        if (map.size() <= 2) 
            return new ArrayList<>(map.keySet());
        
        List<Integer> list = new ArrayList<>();
        for (Integer leaf : leaves) {
            Integer neighbor = map.get(leaf).get(0);
            map.get(neighbor).remove(leaf);
            if (map.get(neighbor).size() == 1) list.add(neighbor);
            map.remove(leaf);
        }
        
        return prone(map, list);
    }
}