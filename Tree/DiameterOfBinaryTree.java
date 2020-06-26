// Leetcode solution

class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max, leftDepth + rightDepth);
            return 1 + Math.max(leftDepth, rightDepth);    
        }    
    }
}