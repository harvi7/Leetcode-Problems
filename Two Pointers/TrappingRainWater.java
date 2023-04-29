// https://leetcode.com/problems/trapping-rain-water/solution/
// https://www.youtube.com/watch?v=wz00uI9mDXA

class Solution {
    public int trap(int[] height) {
//         int totalAmount = 0;
//         if (height == null || height.length == 0)
//             return totalAmount;
        
//         int[] leftHighest = new int[height.length + 1];
//         leftHighest[0] = 0;
        
//         for (int i = 0; i < height.length; i++)
//             leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);
        
//         int rightHighest = 0;
        
//         for (int i = height.length - 1; i >= 0; i--) {
//             rightHighest = Math.max(height[i], rightHighest);
//             totalAmount += Math.min(leftHighest[i], rightHighest) > height[i] ? Math.min(leftHighest[i], rightHighest) - 
//                 height[i] : 0;
//         }
//         return totalAmount;
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else ans += left_max - height[left];
                ++left;
            }
            else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
}