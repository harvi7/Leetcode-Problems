https://www.youtube.com/watch?v=hM9tzzlRcnM

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        int levelSum = 0;
        while (!queue.isEmpty()) {
            levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return  levelSum;
    }
}