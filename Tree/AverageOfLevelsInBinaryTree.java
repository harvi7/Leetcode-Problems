// https://www.youtube.com/watch?v=NW3aCTwdXxs

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        double levelSum = 0;
        while (!q.isEmpty()) {
            levelSum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                levelSum += currNode.val;
                if (currNode.left != null) q.offer(currNode.left);
                if (currNode.right != null) q.offer(currNode.right);
            }
            double levelAvg = levelSum / size;
            result.add(levelAvg);
        }
        return result;
    }
}