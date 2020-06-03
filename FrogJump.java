// https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations

class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0 || stones[1] != 1 ||
                stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) return false;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) 
            map.put(stones[i], new HashSet<>());
        map.get(1).add(1);
        
        for (int i = 1; i < stones.length; i++) {
            int index = stones[i];
            if (map.keySet().contains(index)) {
                for (int step : map.get(index)) {
                    if (map.containsKey(index + step - 1) && step - 1 != 0) 
                        map.get(index + step - 1).add(step - 1);
                    if (map.containsKey(index + step)) 
                        map.get(index + step).add(step);
                    if (map.containsKey(index + step + 1)) 
                        map.get(index + step + 1).add(step + 1);
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}