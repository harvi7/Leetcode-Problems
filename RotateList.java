class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            ++n;
            tail = tail.next;
        }
        k %= n;
        if (k == 0) return head;
        int stepsToNewHead = n - k;
        tail.next = head;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}