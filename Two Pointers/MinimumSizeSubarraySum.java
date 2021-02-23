// https://www.youtube.com/watch?v=jKF9AcyBZ6E

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, sum = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s) {
                result = Math.min(result, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}