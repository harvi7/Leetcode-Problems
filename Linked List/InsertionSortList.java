// https://leetcode.com/problems/insertion-sort-list/discuss/190913/Java-Python-with-Explanations

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode preInsert, toInsert, dummyHead = new ListNode(0);
        dummyHead.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
            } else {      
                toInsert = head.next;
                preInsert = dummyHead;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                head.next = toInsert.next;
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        
        return dummyHead.next;
    }
}