// https://leetcode.com/problems/construct-string-from-binary-tree/solution/

class Solution {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        if (t.left==null && t.right==null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";  
    }
}