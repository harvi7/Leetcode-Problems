class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return helper(root.left, sum) || helper(root.right, sum);
    }
}