// https://www.youtube.com/watch?reload=9&v=Dxv_kCAYOk4

class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                    count++;
                }
                else {
                    nums[i] = nums[i - 1];
                    count++;
                }
            }
        }
        return count <= 1;
    }
}