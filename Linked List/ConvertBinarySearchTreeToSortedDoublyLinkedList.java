// https://www.youtube.com/watch?v=oY7d3lsC3Ew

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node pre = null;
        Node head = null;
        
        Deque<Node> stack = new ArrayDeque<>();
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;   
            }
            
            root = stack.pop();
            if (pre == null) {
                head = root;   
            }
            else {
                pre.right = root;
                root.left = pre;
            }
            pre = root;
            root = root.right;
        }
        pre.right = head;
        head.left = pre;
        return head;   
    }
}