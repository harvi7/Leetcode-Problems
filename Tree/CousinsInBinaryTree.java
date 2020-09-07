// https://leetcode.com/problems/cousins-in-binary-tree/solution/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                TreeNode node = queue.remove();
                if (node == null)
                    siblings = false;
                else {
                    if (node.val == x || node.val == y) {
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            return !siblings;
                        }
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    queue.add(null);
                }
            }
            if (cousins) return false;
        }
        return false;
    }
}