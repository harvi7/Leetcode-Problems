// https://www.youtube.com/watch?v=sFt3KVGyeWw

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        int n = 10;
        List<Integer> result = new ArrayList();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        
        for (int length = lowLen; length < highLen + 1; ++length) {
            for (int start = 0; start < n - length; ++start) {
                int num = Integer.parseInt(digits.substring(start, start + length));
                if (num >= low && num <= high) result.add(num);
            }
        }
        return result;
    }
}