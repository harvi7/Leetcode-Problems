// https://www.youtube.com/watch?v=U-k2GfZvq2M
// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution {
    public int computeSum(int[] nums, int x) {
        int s = 0;
        for (int n : nums) {
            s += n / x + (n % x == 0 ? 0 : 1); 
        }
        return s;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[nums.length - 1];
        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            int num = computeSum(nums, pivot);

            if (num > threshold) {
                left = pivot + 1;    
            } else {
                right = pivot - 1;    
            }    
        }
        return left;
    }
}