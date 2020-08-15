// https://www.youtube.com/watch?v=HxpelXxPFnE

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, new StringBuilder());
    }
    
    public int sumRootToLeaf(TreeNode root, StringBuilder builder) {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            return Integer.parseInt(builder.toString(), 2);
        }
        
        builder.append(root.val);
        return sumRootToLeaf(root.left, new StringBuilder(builder)) +
            sumRootToLeaf(root.right, new StringBuilder(builder));
    }
}