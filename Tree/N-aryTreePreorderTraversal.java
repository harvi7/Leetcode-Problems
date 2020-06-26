// https://www.youtube.com/watch?v=HOMjIiztImo&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=9

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        
        if (root == null) return res;
        
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node child: node.children)
                stack.add(child);
        }
        return res; 
    }
}