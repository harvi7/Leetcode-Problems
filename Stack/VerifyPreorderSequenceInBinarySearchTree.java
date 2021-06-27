// https://www.youtube.com/watch?v=0kkVobZ6Ebc

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lastPopped = Integer.MIN_VALUE;
        
        for (int x : preorder) {
            if (lastPopped > x) return false;
            while (!stack.isEmpty() && x > stack.peek()) lastPopped = stack.pop();
            stack.push(x);
        }
        return true;
    }
}
