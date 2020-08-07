// https://www.youtube.com/watch?v=ylhH3S9m7Vw

class Solution {
    public TreeNode convertBST(TreeNode root) {
        // if (root != null) {
        //     convertBST(root.right);
        //     sum += root.val;
        //     root.val = sum;
        //     convertBST(root.left);
        // }
        // return root;
        Stack<Integer> s1 = new Stack<Integer>();
        helper1(root, s1);
        Stack<Integer> s2 = new Stack<Integer>();
        while (!s1.isEmpty()) {
            if (s2.isEmpty())
                s2.push(s1.pop());
            else
                s2.push(s2.peek() + s1.pop());
        }
        helper2(root, s2);
        return root;
    }
    
    public void helper1(TreeNode root, Stack<Integer> s) {
        if (root == null) return;
        helper1(root.left, s);
        s.push(root.val);
        helper1(root.right, s);
    }
    
    public void helper2(TreeNode root, Stack<Integer> s) {
        if (root== null) return;
        helper2(root.left, s);
        root.val = s.pop();
        helper2(root.right, s);
    }
}