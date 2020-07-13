// https://www.youtube.com/watch?v=LR3K5XAWV5k

class Solution {
    TreeNode firstNode, secondNode, prevNode;
    
    public void recoverTree(TreeNode root) {
        findSegments(root);
        int x = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = x;
    }
    
    private void findSegments(TreeNode root) {
        if (root == null) return;
        findSegments(root.left);
        if (prevNode != null && prevNode.val > root.val) {
            if (firstNode == null)
                firstNode = prevNode;
            secondNode = root;
        }
        prevNode = root;
        findSegments(root.right);
    }
}
