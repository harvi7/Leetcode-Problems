// https://www.youtube.com/watch?v=jWeS4LTqLFA

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int res = 0;
        while (!set.isEmpty()) {
            int x = set.iterator().next();
            set.remove(x);
            int lowerBound = x - 1;
            while (set.contains(lowerBound)) {
                set.remove(lowerBound);
                --lowerBound;
            }
            int upperBound = x + 1;
            while (set.contains(upperBound)) {
                set.remove(upperBound);
                ++upperBound;
            }
            res = Math.max(res, upperBound - lowerBound - 1);
        }
        return res;
    }
}