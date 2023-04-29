class NumArray {
    
    private int[] dp;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
