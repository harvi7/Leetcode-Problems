class Solution {
    public String removeVowels(String S) {
        String vowels ="oeiuaAEIUO";
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            if (vowels.indexOf(c) == -1)
                sb.append(c);
        }
        return sb.toString();
    }
}