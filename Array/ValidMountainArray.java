// https://www.youtube.com/watch?v=WWysBX-N2Ak

class Solution {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i + 1 < A.length && A[i] < A[i + 1])
            i++;
        
        if (i == 0 || i + 1 >= A.length) return false;
        
        while (i + 1 < A.length)
            if (A[i] <= A[i++ + 1]) return false;
        return true;
    }
}