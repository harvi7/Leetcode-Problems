// https://www.youtube.com/watch?v=CjKJDloMnwE

class Solution {
    public int hIndex(int[] citations) {
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          if (citations[pivot] == n - pivot) return n - pivot;
          else if (citations[pivot] < n - pivot) left = pivot + 1;
          else right = pivot - 1;
        }
        return n - left;
    }
}