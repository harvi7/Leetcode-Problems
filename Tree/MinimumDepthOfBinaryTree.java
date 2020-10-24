class Solution {
    public int minDepth(TreeNode root) {
//         if (root == null) return 0;
        
//         return findMinDepth(root);
//     }
    
//     private int findMinDepth(TreeNode root) {
//         if (root == null) return Integer.MAX_VALUE;
//         if (root.left == null && root.right == null) {
//             return 1;
//         }
        
//         return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
        
        // iteratively, BFS
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode n = queue.poll();
                if (n.left == null && n.right == null) return depth;
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            depth++;
        }
        return depth;
     }
}

// iteratively, BFS
// public int minDepth(TreeNode root) {
//     if (root == null) return 0;      
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int depth = 1;
//         while (!queue.isEmpty()) {
//             int l = queue.size();
//             for (int i = 0; i < l; i++) {
//                 TreeNode n = queue.poll();
//                 if (n.left == null && n.right == null) return depth;
//                 if (n.left != null) queue.add(n.left);
//                 if (n.right != null) queue.add(n.right);
//             }
//             depth++;
//         }
//         return depth;
// }