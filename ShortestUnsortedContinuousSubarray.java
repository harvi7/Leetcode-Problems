// https://www.youtube.com/watch?v=p-O7FExDH1M

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                sorted = false;
            if (!sorted)
                min = Math.min(min, nums[i]);
        }
        sorted = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                sorted = false;
            if (!sorted)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}