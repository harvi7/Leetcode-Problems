// https://www.youtube.com/watch?v=6l8l2tvxtD4

class Solution {
    public String toGoatLatin(String S) {
        HashSet<Character> vowels = new HashSet();
        for (char c : "aeiouAEIOU".toCharArray())
            vowels.add(c);
        
        String result = "";
        int index = 1;
        for (String word : S.split("\\s")) {
            if (index > 1)
                result += " ";
            
            if (vowels.contains(word.charAt(0)))
                result += word + "ma";
            else
                result += word.substring(1) + word.charAt(0) + "ma";
            
            for (int j = 0; j < index; j++)
                result += "a";
            
            index += 1;
        }
        return result;
    }
}