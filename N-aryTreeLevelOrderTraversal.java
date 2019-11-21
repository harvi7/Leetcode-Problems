class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node child : curr.children)
                    queue.offer(child);
            }
            res.add(curLevel);
        }
        return res;
    }
}