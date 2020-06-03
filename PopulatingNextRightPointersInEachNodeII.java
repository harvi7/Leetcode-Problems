// https://www.youtube.com/watch?v=vy2mnT3TEXQ

class Solution {
    public Node connect(Node root) {
        Node parent = root;
        Node childHead = null, child = null;
        while (parent != null) {
            while (parent != null) {
                if (parent.left != null) {
                    if (childHead == null)
                        childHead = parent.left;
                    else
                        child.next = parent.left;
                    child = parent.left;
                } 

                if (parent.right != null) {
                    if (childHead == null)
                        childHead = parent.right;
                    else
                        child.next = parent.right;
                    child = parent.right;
                }
                parent = parent.next;
            }
            parent = childHead;
            childHead = child = null;
        }
        return root;
    }
}