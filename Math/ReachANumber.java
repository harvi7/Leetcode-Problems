// https://www.youtube.com/watch?v=pGVnBT1bI6E

class Solution {
    public int reachNumber(int target) {
        int sum = 0, k = 0;
        target = Math.abs(target);
        while (sum < target || (sum != target && (sum - target) % 2 != 0)) {
            sum = sum + k;
            k++;
        }
        return k > 0 ? k - 1 : 0;
    }
}