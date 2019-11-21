//https://www.youtube.com/watch?v=sm4UdCO2868&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=43

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end  = false;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) 
                end = true;
            else {
                if (end) return false;
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }
        return true;
    }
}