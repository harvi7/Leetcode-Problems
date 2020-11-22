// https://www.youtube.com/watch?v=PNJoyRaIW7U

class Solution {
    public void moveZeroes(int[] nums) {
        // if (nums == null || nums.length == 0) return ;
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0)
        //         nums[count++] = nums[i];
        // }
        // for (int i = count; i < nums.length; i++) {
        //     nums[i] = 0;
        // }
        int n = nums.length;
        if (n == 0 || n == 1) return;
        
        int left = 0, right = 0;
        
        while (right < n) {
            if (nums[right] == 0)
                right++;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }
}