// https://www.youtube.com/watch?v=Ds5e1A88j7Q

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) return res;
        
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return res;
    }
}