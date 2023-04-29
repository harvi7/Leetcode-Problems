// https://leetcode.com/problems/put-boxes-into-the-warehouse-i/solution/

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int i = boxes.length - 1;
        int count = 0;
        Arrays.sort(boxes);

        for (int room : warehouse) {
            while (i >= 0 && boxes[i] > room) {
                i--;
            }

            if (i == -1) return count;
            count++;
            i--;
        }

        return count;
    }
}