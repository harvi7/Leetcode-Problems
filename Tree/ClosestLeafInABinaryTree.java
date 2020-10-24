// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms

class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();  
        Queue<TreeNode> queue = new LinkedList<>();          
        Set<TreeNode> visited = new HashSet<>();             
        
        TreeNode kNode = DFS(root, k, backMap);
        queue.add(kNode);
        visited.add(kNode);
        
        while (!queue.isEmpty()) {  
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }
            if (curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if (curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if (backMap.containsKey(curr) && visited.add(backMap.get(curr))) {  // go alone the back edge
                queue.add(backMap.get(curr));
            }
        }
        return -1;
    }
    
    private TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if (root.val == k) {
            return root;
        }
        if (root.left != null) {
            backMap.put(root.left, root);        
            TreeNode left = DFS(root.left, k, backMap);
            if (left != null) return left;
        }
        if (root.right != null) {
            backMap.put(root.right, root);      
            TreeNode right = DFS(root.right, k, backMap);
            if (right != null) return right;
        }
        return null;
    }
}