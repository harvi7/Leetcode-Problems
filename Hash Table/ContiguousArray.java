// https://leetcode.com/problems/contiguous-array/solution/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        
        int max_length = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1); 
            if (counts.containsKey(count)) {
                max_length = Math.max(max_length, i - counts.get(count));
            } else {
                counts.put(count, i);
            }
        }
        return max_length;
    }
}