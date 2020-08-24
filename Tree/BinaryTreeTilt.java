// https://leetcode.com/problems/binary-tree-tilt/solution/

class Solution {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    
    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = traverse(root.left);
        int right = traverse(root.right);
        
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}