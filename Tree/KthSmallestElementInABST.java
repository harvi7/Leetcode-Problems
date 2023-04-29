// https://www.youtube.com/watch?v=C6r1fDKAW_o

class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         int[] nums = new int[2];
//         inorder(root, nums, k);    
//         return nums[1];
//     }
    
//     public void inorder(TreeNode root, int[] nums, int k) {
//         if (root == null) return;
//         inorder(root.left, nums, k);
//         if (++nums[0] == k) {
//             nums[1] = root.val;
//             return;
//         }
//         inorder(root.right, nums, k);
//     }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}