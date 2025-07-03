class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        int sign = 1, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i; 
        if (i >= n ) return 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') sign = str.charAt(i++) == '+' ? 1 : -1;
        long res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            res = res * 10 + (str.charAt(i++) - '0');
            if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
        }
        return (int) (res * sign);
    }
}