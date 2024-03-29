class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}