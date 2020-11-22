// https://www.youtube.com/watch?v=GSJuwQzKSnI

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ListNode dummy = new ListNode(-1), pre = dummy;
        // dummy.next = head;
        // for (int i = 0; i < m - 1; i++) pre = pre.next;
        // ListNode cur = pre.next;
        // while (m++ < n) {
        //     ListNode tmp = cur.next;
        //     cur.next = tmp.next;
        //     tmp.next = pre.next;
        //     pre.next = tmp;
        // }
        // return dummy.next;
        // Empty list
        
        if (head == null) return null;
        
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode connection = prev, tail = cur;
        while (n > 0) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            n--;
        }

        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}