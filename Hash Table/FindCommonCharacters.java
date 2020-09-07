class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        Map<Character, Integer>  counter = null;
        Map<Character, Integer> min = new HashMap<Character, Integer>();
        
        for(int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            min.put(ch, Integer.MAX_VALUE);
        }

        for(String word : A) {
            counter = new HashMap<Character, Integer>();

            for(char ch : word.toCharArray()) {
                counter.put(ch, counter.getOrDefault(ch, 0) + 1);
            }
            
            for(Map.Entry<Character, Integer> entry : min.entrySet()) {
                char alphabet = entry.getKey();
                int currentValue = counter.containsKey(alphabet) ? counter.get(alphabet) : 0;
                int currentMinValue = entry.getValue();
                min.put(alphabet, Math.min(currentMinValue, currentValue));
            }
        }

        for(Map.Entry<Character, Integer> entry : min.entrySet()) {
            int count = entry.getValue();
            while(count-- > 0) {
                result.add("" + entry.getKey());
            }
        }
        return result;
    }
}