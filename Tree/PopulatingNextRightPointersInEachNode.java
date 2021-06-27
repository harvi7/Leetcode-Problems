class Solution {
    public Node connect(Node root) {
        Node leftNode = root;
        while (leftNode != null && leftNode.left != null) {
            populateLowerLevel(leftNode);
            leftNode = leftNode.left;
        }
        return root;
    }
    
    private void populateLowerLevel(Node startNode) {
        Node iter = startNode;
        while (iter != null) {
            iter.left.next = iter.right;
            if (iter.next != null)
                iter.right.next = iter.next.left;
            iter = iter.next;
        }    
    }
}