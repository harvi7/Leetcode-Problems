// https://leetcode.com/problems/monotone-increasing-digits/discuss/128514/Simple-java-solution-with-clear-explanation.-Very-easy-to-understand.
// https://leetcode.com/problems/monotone-increasing-digits/solution/

class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] ch = String.valueOf(N).toCharArray();
        int mark = ch.length;
        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i] < ch[i - 1]) {
                mark = i - 1;
                ch[i - 1]--;
            }
        }

        for (int i = mark + 1; i < ch.length; i++)
            ch[i] = '9';
        return Integer.parseInt(new String(ch));
    }
}