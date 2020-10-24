// https://leetcode.com/problems/plus-one-linked-list/solution/

class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        while (head != null) {
          if (head.val != 9) notNine = head;
          head = head.next;
        }

        notNine.val++;
        notNine = notNine.next;

        while (notNine != null) {
          notNine.val = 0;
          notNine = notNine.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
    }
}