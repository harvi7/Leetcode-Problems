// class Solution {
//     public Node connect(Node root) {
//         Node leftNode = root;
//         while (leftNode != null && leftNode.left != null) {
//             populateLowerLevel(leftNode);
//             leftNode = leftNode.left;
//         }
//         return root;
//     }
    
//     private void populateLowerLevel(Node startNode) {
//         Node iter = startNode;
//         while (iter != null) {
//             iter.left.next = iter.right;
//             if (iter.next != null)
//                 iter.right.next = iter.next.left;
//             iter = iter.next;
//         }    
//     }
// }


class Solution {
    public Node connect(Node root) {    
        if (root == null) return root;
        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}