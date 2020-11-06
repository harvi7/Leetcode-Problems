// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/discuss/352417/Solution-in-Python-3-(beats-~99)-(With-Detailed-Explanation)-(-O(n)-time-)-(-O(1)-space-)

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        if (sum % 3 != 0) return false;
        int target = sum / 3, count = 0, curSum = 0;
        for (int num : A) {
            curSum += num;
            if (curSum == target) {
                curSum = 0;
                count++;
            }
        }
        return count >= 3;
    }
}