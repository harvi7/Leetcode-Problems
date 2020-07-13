// https://www.youtube.com/watch?v=HdMs2Fl_I-Q
// https://leetcode.com/problems/subtree-of-another-tree/discuss/626138/Java-Very-simple-to-understand!

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t))
            return true;
        if (s.left != null && isSubtree(s.left, t))
                return true;
        if (s.right != null && isSubtree(s.right, t))
                return true;
        return false;
    }
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == t)
            return true;
        if (s == null || t == null) 
            return false;
        if (s.val != t.val) 
            return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    } 
}

