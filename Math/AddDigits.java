class Solution {
    public int addDigits(int num) {
        if (num <= 9) return num;
        
        int sum = 0;
        while (num > 0) {
            int onesPlace = num % 10;
            sum += onesPlace;
            num /= 10;
        }
        return addDigits(sum);
    }
}