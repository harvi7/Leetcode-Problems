// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/

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

// class Solution {

//     private ListNode head;

//     private int findSize(ListNode head) {
//         ListNode ptr = head;
//         int c = 0;
//         while (ptr != null) {
//           ptr = ptr.next;  
//           c += 1;
//         }
//         return c;
//     }

//     private TreeNode convertListToBST(int l, int r) {
//         if (l > r) return null;

//         int mid = (l + r) / 2;

//         TreeNode left = this.convertListToBST(l, mid - 1);

//         TreeNode node = new TreeNode(this.head.val);
//         node.left = left;

//         this.head = this.head.next;

//         node.right = this.convertListToBST(mid + 1, r);
//         return node;
//     }

//     public TreeNode sortedListToBST(ListNode head) {
//         int size = this.findSize(head);

//         this.head = head;

//         return convertListToBST(0, size - 1);
//     }
// }