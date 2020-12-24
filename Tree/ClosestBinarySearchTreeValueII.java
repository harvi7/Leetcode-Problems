// https://www.youtube.com/watch?v=3GN3DaJv9_g

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        inOrder(root, target, k, res);
        return res;
    }
    
    private void inOrder(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null) return;
        inOrder(root.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - res.peek())) res.remove();
            else return;
        }
        res.add(root.val);
        inOrder(root.right, target, k, res);
    }
}

// public List<Integer> closestKValues(TreeNode root, double target, int k) {
//         List<Integer> nums = new ArrayList();

//         Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
//         inorder(root, nums, heap, k);
//         return new ArrayList<>(heap);
//     }
    
//     public void inorder(TreeNode r, List<Integer> nums, Queue<Integer> heap, int k) {
//         if (r == null) 
//             return;
                    
//         inorder(r.left, nums, heap, k);
//         heap.add(r.val);
//         if (heap.size() > k) 
//             heap.remove();
//         inorder(r.right, nums, heap, k);
//     }