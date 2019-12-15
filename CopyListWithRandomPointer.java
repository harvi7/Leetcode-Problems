// https://www.youtube.com/watch?v=OvpKeraoxW0&list=PLiQ766zSC5jMEpcGL0nSkfDM3paBP5FOE&index=3

class Solution {
    public Node copyRandomList(Node head) {
        
        // Linear Space Approach
//         if (head == null) return null;
//         Map<Node, Node> cloneMap = new HashMap<Node, Node>();
//         Node curr = head;
//         while (curr != null) {
//           cloneMap.put(curr, new Node(curr.val));
//           curr = curr.next;
//         }
        
//         curr = head;
//         while (curr != null) {
//           cloneMap.get(curr).next = cloneMap.get(curr.next);
//           cloneMap.get(curr).random = cloneMap.get(curr.random);
//           curr = curr.next;
//         }
//         return cloneMap.get(head);
        
        // Constant Space Approach
        Node curr = head;
        Node next = null;
        
        while (curr != null) {
          next = curr.next;
          Node copy = new Node(curr.val);
          curr.next = copy;
          copy.next = next;
          curr = next;
        }
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;

        Node dummyHead = new Node(0);
        Node cloneListTail = dummyHead;
        Node copy = null;

        while (curr != null) {
            next = curr.next.next;
            copy = curr.next;
            cloneListTail.next = copy;
            cloneListTail = copy;
            curr.next = next;

            curr = next;
        }
        return dummyHead.next;
    }
}