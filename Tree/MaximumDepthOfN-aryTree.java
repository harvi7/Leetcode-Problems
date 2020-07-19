class Solution {
    private int maxDepth;
    public int maxDepth(Node root) {
        
        if (root == null) return 0;
        
        // BFS Solution
//         int depth = 0;
        
//         Queue<Node> queue = new LinkedList();
//         queue.offer(root);
//         int qSize = 0;
//         while (!queue.isEmpty()) {
//             qSize = queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 Node currNode = queue.poll();
//                 for (Node child : currNode.children)
//                     queue.offer(child);
//             }
//             depth++;
//         }
//         return depth;
        
         //DFS Solution
        getMaxDepth(root, 1);
        return maxDepth;
    }
    
    private void getMaxDepth(Node node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        for (Node child: node.children)
            getMaxDepth(child, depth + 1);
    }
}