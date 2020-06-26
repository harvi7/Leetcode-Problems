class Solution {
    int totalPaths = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        traverseAllPaths(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        
        return totalPaths;
    }
    
    void traverseAllPaths(TreeNode root, int sum, int currentSum) {
        if (root == null) return;
        
        currentSum += root.val;
        
        if (sum == currentSum)
            totalPaths++;
        
        traverseAllPaths(root.left, sum, currentSum);
        traverseAllPaths(root.right, sum, currentSum);
    }
}