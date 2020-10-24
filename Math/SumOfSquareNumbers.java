// https://leetcode.com/problems/sum-of-square-numbers/solution/
// https://www.youtube.com/watch?v=cZXVlhiXSwI&t=256s - The proof is quite complicated but this will give an idea

class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}