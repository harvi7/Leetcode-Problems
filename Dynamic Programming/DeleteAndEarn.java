// https://leetcode.com/problems/delete-and-earn/solution/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        int avoid = 0, using = 0, prev = -1;
        
        for (int key : count.keySet()) {
            int m = Math.max(avoid, using);
            if (key - 1 != prev) {
                using = key * count.get(key) + m;
                avoid = m;
            } else {
                using = key * count.get(key) + avoid;
                avoid = m;
            }
            prev = key;
        }
        return Math.max(avoid, using);
    }
}