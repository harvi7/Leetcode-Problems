class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high); 
        
        // Iterative approach
        // int ans = 0;
        // Stack<TreeNode> stack = new Stack();
        // stack.push(root);
        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.pop();
        //     if (node != null) {
        //         if (L <= node.val && node.val <= R)
        //             ans += node.val;
        //         if (L < node.val)
        //             stack.push(node.left);
        //         if (node.val < R)
        //             stack.push(node.right);
        //     }
        // }
        // return ans;
    }
}