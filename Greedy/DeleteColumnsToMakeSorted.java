// https://leetcode.com/problems/delete-columns-to-make-sorted/solution/

class Solution {
    public int minDeletionSize(String[] A) {
        int ans = 0, length = A[0].length();
        for (int c = 0; c < length; ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r + 1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }
}