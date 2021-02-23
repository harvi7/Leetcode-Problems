// https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/solution/

class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                // if it's the given node
                if (curr == u) {
                    if (i == levelSize - 1) {
                        return null;
                    }
                    else {
                        return queue.poll();
                    }
                }

                if (curr.left != null) queue.offer(curr.left);    
                if (curr.right != null) queue.offer(curr.right);
            }
        } 
        return null;
    }
}