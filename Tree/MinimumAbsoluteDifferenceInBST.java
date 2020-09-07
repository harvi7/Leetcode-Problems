// https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/786798/java-solution

class Solution {
    TreeNode preNode = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
	    return minDiff;
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (preNode != null)
            minDiff = Math.min(minDiff, root.val - preNode.val);
        preNode = root;
        inorder(root.right);
    }
}