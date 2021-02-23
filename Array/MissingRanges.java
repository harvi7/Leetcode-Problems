// https://leetcode.com/problems/missing-ranges/solution/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int cur = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= cur - 1)
                result.add(formatRange(prev + 1, cur - 1));
            prev = cur;
        }
        return result;
    }
    
    private String formatRange(int lower, int upper) {
        if (lower == upper)
            return String.valueOf(lower);
        return lower + "->" + upper;
    }
}