// https://www.youtube.com/watch?v=g8bSdXCG-lA
// https://www.youtube.com/watch?v=RVIh0snn4Qc
// https://leetcode.com/problems/maximal-rectangle/discuss/29055/My-java-solution-based-on-Maximum-Rectangle-in-Histogram-with-explanation

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int cols = matrix[0].length, rows = matrix.length, res = 0;
        int[] heights = new int[cols];
        for (char[] row : matrix) {
            for (int c = 0; c < cols; c++) {
                if (row[c] == '1') heights[c]++;
                else heights[c] = 0;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }
    
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
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