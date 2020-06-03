// https://www.youtube.com/watch?v=12omz-VAyRk&t=5s

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructBSTRecursive(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right- left) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBSTRecursive(nums, left, mid - 1);
        current.right = constructBSTRecursive(nums, mid + 1, right);
        return current;
    }
}