// https://www.youtube.com/watch?v=tDn9O7UQ4E8

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode n : lists) 
            if (n != null) 
                pq.offer(n);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = n;
            if (n.next != null) pq.offer(n.next);
        }
        return dummy.next;
    }
}