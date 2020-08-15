// https://www.youtube.com/watch?v=Wv6DlL0Sawg

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList();
        
        Integer[] dp = new Integer[n + 1];
        Arrays.sort(nums);
        int max = 1;
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    if (max < dp[i])
                        max = dp[i];
                }
            }
        }
        LinkedList<Integer> subset = new LinkedList();
        int prev = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max &&  (prev % nums[i] == 0 || prev == -1)) {
                subset.add(nums[i]);
                max -=1;
                prev = nums[i];
            }
        }
        
        return subset;
    }
}
