// https://www.youtube.com/watch?v=gcULXE7ViZw
// https://leetcode.com/problems/delete-node-in-a-bst/discuss/650562/Java-0ms-beats-100-in-time

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        if (root.val == key) root = delete(root, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key);
        return root;
    }
    
    private TreeNode delete(TreeNode root, int key){
        if (root.left == null && root.right == null)
            return null;
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode helper = root.right;
        while (helper.left != null)
            helper = helper.left;
        helper.left = root.left;
        return root.right;
    }
}

