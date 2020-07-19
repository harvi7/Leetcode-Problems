// https://www.youtube.com/watch?v=cwYVhyl2A1s

class Solution {
    int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        arrowLength(root);
        return result;
    }
    
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) 
            arrowLeft += left + 1;
            
        if (node.right != null && node.right.val == node.val)
            arrowRight += right + 1;
        
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}