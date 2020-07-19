// https://www.youtube.com/watch?v=qVADz0khbH0

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] characters = S.toCharArray();
        int i = 0;
        int j = S.length() - 1;
        
        while (i < j) {
            while (i < j && !Character.isLetter(S.charAt(i)))
                i++;
            while (j > i && !Character.isLetter(S.charAt(j)))
                j--;
            
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        return new String(characters);
    }
}