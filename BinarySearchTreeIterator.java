// https://www.youtube.com/watch?v=aRLSJFv-80k

class BSTIterator {
    
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftMostInorder(root);
    }
    
    private void leftMostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        leftMostInorder(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}