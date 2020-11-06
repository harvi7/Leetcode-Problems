// https://www.youtube.com/watch?v=B97Hk1H2x2s
// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/solution/

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque(), stack2 = new ArrayDeque();
        List<Integer> result = new ArrayList();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
          while (root1 != null) {
            stack1.push(root1);
            root1 = root1.left;
          }
          while (root2 != null) {
            stack2.push(root2);
            root2 = root2.left;
          }

          if (stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val) {
            root1 = stack1.pop();
            result.add(root1.val);
            root1 = root1.right;
          }
          else {
            root2 = stack2.pop();
            result.add(root2.val);
            root2 = root2.right;
          }
        }
        return result;
    }
}