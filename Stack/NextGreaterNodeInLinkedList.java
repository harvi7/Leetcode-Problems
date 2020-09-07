// https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/806447/Java-linear-time-space-complexity-solution

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        int[] result = new int[values.size()];
        Stack<Integer> afterValues = new Stack<>();
        for (int i = values.size() - 1; i >= 0; i--) {
            while (!afterValues.isEmpty() && afterValues.peek() <= values.get(i))
                afterValues.pop();
            
            int nextGreater = afterValues.isEmpty() ? 0: afterValues.peek();
            result[i] = nextGreater;
            afterValues.push(values.get(i));
        }  
        return result;
    }
}