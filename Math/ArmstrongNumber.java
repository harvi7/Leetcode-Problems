class Solution {
    public boolean isArmstrong(int N) {
        String s = Integer.toString(N);
        int len = s.length();
        int copy = N;
        int sum = 0;
        while (copy != 0) {
            int digit = copy % 10;
            sum += Math.pow(digit, len);
            copy /= 10;
        }
        return sum == N;
    }
}