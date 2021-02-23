// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solution/
// https://www.youtube.com/watch?v=4jPWRdlcO-Y&list=PLamEquLLzOtjp9j_vAIS6KUeeFzKEjDz2&index=7

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }
    
    public int helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return curMax - curMin;
        }

        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
    }
}