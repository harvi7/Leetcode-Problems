// https://leetcode.com/problems/longest-consecutive-sequence/solution/
// https://www.youtube.com/watch?v=jWeS4LTqLFA

class Solution {
    public int longestConsecutive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums)
        //     set.add(num);
        // int res = 0;
        // while (!set.isEmpty()) {
        //     int x = set.iterator().next();
        //     set.remove(x);
        //     int lowerBound = x - 1;
        //     while (set.contains(lowerBound)) {
        //         set.remove(lowerBound);
        //         --lowerBound;
        //     }
        //     int upperBound = x + 1;
        //     while (set.contains(upperBound)) {
        //         set.remove(upperBound);
        //         ++upperBound;
        //     }
        //     res = Math.max(res, upperBound - lowerBound - 1);
        // }
        // return res;

        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}