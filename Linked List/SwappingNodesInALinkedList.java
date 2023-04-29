class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int listLength = 0;
        ListNode frontNode = null, endNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            listLength++;
            if (endNode != null)
                endNode = endNode.next;

            if (listLength == k) {
                frontNode = currentNode;
                endNode = head;
            }
            currentNode = currentNode.next;
        }

        int temp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = temp;
        return head;
    }
}