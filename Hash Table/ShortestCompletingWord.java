// https://leetcode.com/problems/shortest-completing-word/solution/

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word: words)
            if ((word.length() < ans.length() || ans.length() == 0) && dominates(count(word.toLowerCase()), target))
                ans = word;
        return ans;
    }
    
    public boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++)
            if (count1[i] < count2[i])
                return false;
        return true;
    }

    public int[] count(String word) {
        int[] result = new int[26];
        for (char letter: word.toCharArray()){
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26)
                result[index]++;
        }
        return result;
    }
}