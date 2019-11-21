class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return res;
    }
}