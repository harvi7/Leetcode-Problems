class Solution {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) 
            min = Math.min(A[i], min);
        
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min = min / 10;
        }
        return 1 - sum % 2;
    }
}