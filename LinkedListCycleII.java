// https://leetcode.com/problems/linked-list-cycle-ii/discuss/44777/Concise-JAVA-solution-based-on-slow-fast-pointers

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;				
            }
	    }			
	    return null;
    }
}