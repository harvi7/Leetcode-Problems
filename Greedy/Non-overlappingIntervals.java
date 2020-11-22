// https://www.youtube.com/watch?v=BTObFnHbD4U

class Solution {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
          return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int count = 0, n = intervals.length, left = 0, right = 1; 

        while (right < n) {
            if (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right += 1;
            }
            else if(intervals[left][1] <= intervals[right][1]) {
                count += 1;      
                right += 1;
            }
            else if(intervals[left][1] > intervals[right][1]) {
                count +=1;
                left = right;
                right += 1;
            }
        }
        return count;
    }
}


       