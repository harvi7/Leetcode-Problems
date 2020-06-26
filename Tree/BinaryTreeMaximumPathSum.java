// https://www.youtube.com/watch?v=mOdetMWwtoI
// https://www.youtube.com/watch?v=TO5zsKtc1Ic

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recMaxSum(root);
        return maxSum;
    }
    
    private int recMaxSum(TreeNode current){
        if (current == null) return 0;
        int left = Math.max(recMaxSum(current.left), 0);
        int right = Math.max(recMaxSum(current.right), 0);

        int sum = current.val + left + right;
        maxSum = Math.max(sum, maxSum);
        return Math.max(left, right) + current.val;
    }
}