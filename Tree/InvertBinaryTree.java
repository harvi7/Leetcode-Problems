class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);
        
        root.right = left;
        root.left = right; 
        
        return root;
        
        // Iterative
        // if (root == null) return null;
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     TreeNode current = queue.poll();
        //     TreeNode temp = current.left;
        //     current.left = current.right;
        //     current.right = temp;
        //     if (current.left != null) queue.add(current.left);
        //     if (current.right != null) queue.add(current.right);
        // }
        // return root;
    }
}