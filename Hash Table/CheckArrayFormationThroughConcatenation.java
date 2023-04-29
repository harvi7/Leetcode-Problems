// https://leetcode.com/problems/check-array-formation-through-concatenation/solution/

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        Map<Integer, int[]> mapping = new HashMap<>();
        for (int[] p : pieces) {
            mapping.put(p[0], p);
        }

        int i = 0;
        while (i < n) {
            if (!mapping.containsKey(arr[i])) {
                return false;
            }

            int[] targetPiece = mapping.get(arr[i]);
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}