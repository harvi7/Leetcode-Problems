// https://www.youtube.com/watch?v=xRYPjDMSUFw

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) 
            return;
        
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l2 = reverse(slow);
        
        merge(l1, l2);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            
            l1.next = l2;
            
            if (l1Next == null)
                break;
            
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}