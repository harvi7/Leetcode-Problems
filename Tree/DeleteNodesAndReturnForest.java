// https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/328853/JavaC%2B%2BPython-Recursion-Solution
// https://www.youtube.com/watch?v=aaSFzFfOQ0o

class Solution {
    List<TreeNode> res = new ArrayList();
    Set<Integer> toDeleteSet = new HashSet<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete)
            toDeleteSet.add(i);
        
        removeNodes(root, true);
        return res;
    }
    
    private TreeNode removeNodes(TreeNode node, boolean is_root) {
        if (node == null) return null;
        boolean toDelete = toDeleteSet.contains(node.val);
        if (is_root && !toDelete) res.add(node);
        node.left = removeNodes(node.left, toDelete);
        node.right =  removeNodes(node.right, toDelete);
        return toDelete ? null : node;
    }
}