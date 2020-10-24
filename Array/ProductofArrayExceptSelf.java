// https://www.youtube.com/watch?v=khTiTSZ5QZY

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        
        int[] res = new int[N];
        
        res[0] = 1;
        for (int i = 1; i < N; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = R * nums[i];
        }
        return res;
    }
}