// https://www.youtube.com/watch?v=YMYVYSWL93w

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        
        int n = nums.length + 1;
        return (n * (n - 1)) / 2 - sum;
    }
}