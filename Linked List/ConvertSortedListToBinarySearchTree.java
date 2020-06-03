class Solution {
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        int len = getLength(head);
        return helper(0, len - 1);
    }

    private TreeNode helper(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode left = helper(lo, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(mid + 1, hi);
        root.left = left;
        root.right = right;
        return root;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}