// https://www.youtube.com/watch?v=2vwTmHTL1Mk

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        level(root, ans);
        return ans;
    }
    
    public Integer level(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return -1;
        int level = Math.max(level(root.left, ans), level(root.right, ans)) + 1;
        if (ans.size() <= level)
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        return level;
    }
}