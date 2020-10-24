// https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode node = pointer;
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;
            
            ListNode prev = null, curr = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}