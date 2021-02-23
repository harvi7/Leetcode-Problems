// https://leetcode.com/problems/validate-binary-search-tree/solution/

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);   
    }
    
    // Recursive Inorder Traversal
//     private Integer prev;
    
//     public boolean isValidBST(TreeNode root) {
//         prev = null;
//         return inorder(root);
//     }
    
//     private boolean inorder(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
//         if (!inorder(root.left)) {
//             return false;
//         }
//         if (prev != null && root.val <= prev) {
//             return false;
//         }
//         prev = root.val;
//         return inorder(root.right);
//     }
    
    
    // Iterative Traversal with Valid Range
//     private Deque<TreeNode> stack = new LinkedList();
//     private Deque<Integer> upperLimits = new LinkedList();
//     private Deque<Integer> lowerLimits = new LinkedList();

//     public void update(TreeNode root, Integer low, Integer high) {
//         stack.add(root);
//         lowerLimits.add(low);
//         upperLimits.add(high);
//     }

//     public boolean isValidBST(TreeNode root) {
//         Integer low = null, high = null, val;
//         update(root, low, high);

//         while (!stack.isEmpty()) {
//             root = stack.poll();
//             low = lowerLimits.poll();
//             high = upperLimits.poll();

//             if (root == null) continue;
//             val = root.val;
//             if (low != null && val <= low) {
//                 return false;
//             }
//             if (high != null && val >= high) {
//                 return false;
//             }
//             update(root.right, val, high);
//             update(root.left, low, val);
//         }
//         return true;
//     }
}