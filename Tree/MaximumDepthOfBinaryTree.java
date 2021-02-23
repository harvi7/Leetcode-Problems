// https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;  
        return maxDepth;
        
        // Iterative approach
//         if (root == null) return 0;
//         Deque<TreeNode> dq = new ArrayDeque<>();
//         int depth = 0, next = 0;
//         TreeNode cur;
//         dq.offer(root);

//         while (!dq.isEmpty()) {
//             depth++;
//             next = dq.size();
//             for (int i = 0; i < next; ++i) {
//                 cur = dq.poll();
//                 if (cur.left != null) dq.offer(cur.left);
//                 if (cur.right != null) dq.offer(cur.right);
//             }
//         }
//         return depth;
    }
}