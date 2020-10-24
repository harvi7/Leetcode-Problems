// https://www.youtube.com/watch?v=QWbVCqIhTO4
// https://www.youtube.com/watch?v=kqHNP6NTzME

class Solution {
    
    class Node {
        TreeNode root;
        int hd;
        int vd;
        public Node(TreeNode root, int hd, int vd) {
            this.root = root;
            this.hd = hd;
            this.vd = vd;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        Map<Integer, List<Node>> columnTable = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0, 0));
        int minHd = 0;
        int maxHd = 0;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            columnTable.putIfAbsent(cur.hd, new ArrayList<>());
            minHd = Math.min(minHd, cur.hd);
            maxHd = Math.max(maxHd, cur.hd);
            
            columnTable.get(cur.hd).add(cur);
            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.hd - 1, cur.vd - 1));
            }
            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.hd + 1, cur.vd - 1));
            }
        }
        
        int index = 0;
        for (int i = minHd; i <= maxHd; i++) {

            Collections.sort(columnTable.get(i), (a, b) -> {
                if (a.vd == b.vd) {
                    return a.root.val - b.root.val;
                } else {
                    return b.vd - a.vd;
                }
            });
            //res.add(columnTable.get(i));
            res.add(new ArrayList<>());
            for (Node node : columnTable.get(i)) {
                res.get(index).add(node.root.val);
            }
            index++;
        }
        
        return res;
    }
}