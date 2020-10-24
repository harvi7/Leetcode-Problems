class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<>(); // Left to Right
        Stack<TreeNode> s2 = new Stack<>(); // Right to Left
        
        s1.push(root);
        List<Integer> list = new ArrayList<>();
        
        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode n = s1.pop();
                list.add(n.val);
                if (n.left != null) s2.push(n.left);
                if (n.right != null) s2.push(n.right);
            }
            if (!list.isEmpty()) res.add(new ArrayList<>(list));
            list.clear();
            while(!s2.isEmpty()) {
                TreeNode n = s2.pop();
                list.add(n.val);
                if (n.right != null) s1.push(n.right);
                if (n.left != null) s1.push(n.left);           
            }
            if (!list.isEmpty()) res.add(new ArrayList<>(list));
            list.clear();
        }
        
        return res;
    }
}