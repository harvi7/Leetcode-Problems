// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int first = find(nums, target, true);
        if (first == -1) return res;
        int last = find(nums, target, false);
        res[0] = first;
        res[1] = last;
        return res;
    }
    
    private int find(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (first) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}