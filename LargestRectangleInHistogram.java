// https://www.youtube.com/watch?v=RVIh0snn4Qc

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else{
                int currMax = stack.pop();
                maxArea = Math.max(maxArea, heights[currMax] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}