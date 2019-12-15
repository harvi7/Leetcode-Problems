class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        // BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return list;
        
        int max = Integer.MIN_VALUE;
        queue.offer(root);
        while (!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            int size=queue.size();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.val > max) max=node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            list.add(max);
        }
        
        //dfs(root,list,1);
        
        return list;
    }
    
    // DFS
//     private void dfs(TreeNode root,List<Integer> list, int depth){
//         if(root==null) return;
//         if(depth > list.size()) list.add(root.val);
//         else list.set(depth-1, Math.max(root.val, list.get(depth-1)));
        
//         if(root.left != null) dfs(root.left, list,depth+1);
//         if(root.right != null) dfs(root.right, list,depth+1);
//     }
}