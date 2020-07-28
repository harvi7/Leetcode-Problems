// https://leetcode.com/problems/shortest-palindrome/discuss/60113/Clean-KMP-solution-with-super-detailed-explanation
// https://www.youtube.com/watch?v=c4akpqTwE5g&t=325s
// https://www.youtube.com/watch?v=BXCEFAzhxGY
// https://www.youtube.com/watch?v=4jY57Ehc14Y

class Solution {
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        int[] table = new int[s.length()];

        int index = 0;
        for (int i = 1; i < s.length(); ) {
            if (s.charAt(i) == s.charAt(index)){
                table[i] = ++index;
                i++;
            } else {
                if (index > 0)
                    index = table[index - 1];
                else {
                    index = 0;
                    i++;
                }
            }
        }
        return table;
    }
}