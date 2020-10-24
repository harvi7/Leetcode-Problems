// https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-%2B-N)time-complexity-Solution

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        
        for(int[] update : updates) {
            int value = update[2], start = update[0], end = update[1];
            res[start] += value;

            if (end < length - 1)
                res[end + 1] -= value;

        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}