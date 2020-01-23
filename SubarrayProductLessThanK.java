// https://www.youtube.com/watch?v=SxtxCSfSGlo
// https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int prod = 1;
        int result = 0;
        
        int left = 0;
        int right = 0;
        
        while (right < nums.length) {
            prod *= nums[right]; 
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }       
        return result;
    }
}
