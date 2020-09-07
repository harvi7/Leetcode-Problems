// https://leetcode.com/problems/find-and-replace-pattern/discuss/816934/Java-Solution-using-one-HashMap-with-comments

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i<words.length; i++) {
            Map<Character, Character> map = new HashMap<>();
            String curr = words[i];
            boolean isValid = false;
            if (curr.length() != pattern.length())
                continue;
            for (int j = 0; j < curr.length(); j++) {
                if (map.containsKey(pattern.charAt(j)) && map.get(pattern.charAt(j)) != curr.charAt(j)) {
                	isValid = false;
                    break;
                }
                else if (!map.containsKey(pattern.charAt(j)) && map.containsValue(curr.charAt(j))) {
                	isValid = false;
                	break;
                }
                else {
                	map.put(pattern.charAt(j), curr.charAt(j));
                	isValid = true;
                }
            }
            if (isValid == true)
            	result.add(curr);
        }
        return result;
    }
}