// https://leetcode.com/problems/clumsy-factorial/discuss/252279/You-never-think-of-this-amazing-O(1)-solution

class Solution {
    public int clumsy(int N) {
        int[] magic = new int[]{1, 2, 2, -1, 0, 0, 3, 3};
        return N + (N > 4 ? magic[N % 4] : magic[N + 3]);
    }
}