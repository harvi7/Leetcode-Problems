// https://www.youtube.com/watch?v=AxkYOnS-hjs&ab_channel=BackToBackSWE
// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/391424/JAVA-4ms-Solution-short-and-precise-O(n)-With-Explanation

class Solution {
    public int maximumSum(int[] arr) {
//         int high = Integer.MIN_VALUE;
//         for(int a : arr) {
//             high = Math.max(high, a);
//         }
//         if(high < 0) {
//             return high;
//         }
        
        
//         int[] forward = new int[arr.length];
//         int currMax = 0;
//         for(int i = 0; i < arr.length; i++) {
//             int a = arr[i];
//             currMax = Math.max(currMax + a, a);
//             forward[i] = currMax; 
//         }
        
//         int[] backward = new int[arr.length];
//         currMax = 0;
//         int bestMax = 0;
//         for(int i = arr.length - 1; i >= 0; i--) {
//             int a = arr[i];
//             currMax = Math.max(currMax + a, a);
//             bestMax = Math.max(currMax, bestMax);
//             backward[i] = currMax;
//         }
        
//         int o = bestMax;
//         for(int i = 1; i < arr.length - 1; i++) {
//             o = Math.max(o, forward[i - 1] + backward[i + 1]);
//         }
//         return o;
        int del = arr[0], res = arr[0], keep = arr[0];
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            del = Math.max(keep, del + arr[i]);
            keep = Math.max(keep + arr[i], arr[i]);
            res = Math.max(res, Math.max(del, keep));
        }
        return res;
    }
}