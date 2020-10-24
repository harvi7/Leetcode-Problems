// https://leetcode.com/problems/maximum-length-of-pair-chain/solution/ 

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int last = Integer.MIN_VALUE, count = 0;

        for(int[] pair : pairs){
            if (last < pair[0]){
                last = pair[1];
                count++;
            }
        }
        return count;
    }
}