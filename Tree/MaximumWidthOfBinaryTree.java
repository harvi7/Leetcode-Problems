class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 1));
        
        int firstIndex = 0;
        int lastIndex = 0;
        
        while (!q.isEmpty()) {
          int qlen = q.size();
          firstIndex = q.peek().getValue();
            
            while(qlen-- > 0) {
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode node = pair.getKey();
                lastIndex = pair.getValue();
                
                if (node.left != null) q.offer(new Pair<>(node.left, 2 * lastIndex));
                if (node.right != null) q.offer(new Pair<>(node.right, 2 * lastIndex + 1));
                
            }
            max = Math.max(max, lastIndex - firstIndex + 1); 
        }
        return max;
    }
}