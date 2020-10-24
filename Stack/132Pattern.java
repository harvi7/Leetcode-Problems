// https://www.youtube.com/watch?v=Fr4SJrgIKrA
// https://leetcode.com/problems/132-pattern/solution/

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int[] aux = new int[nums.length];
        aux[0] = nums[0];
        for (int k = 1; k < nums.length; k++) 
            aux[k] = Math.min(nums[k], aux[k - 1]);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > aux[j]) {
                while (!stack.isEmpty() && stack.peek() <= aux[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}