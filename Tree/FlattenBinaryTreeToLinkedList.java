class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
            
            if (!stack.isEmpty()) 
                currentNode.right = stack.peek();
            
            currentNode.left = null;
        }
    }
}