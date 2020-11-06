class Solution {
    public String[] findWords(String[] words) {
        // return Stream.of(words)
        //         .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
        //         .toArray(String[] :: new);
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        HashMap<Character, Integer> keyboard = new HashMap<>();
        for (int i = 0; i<rows.length; ++i) {
            for (char c: rows[i].toCharArray()) {
                keyboard.put(c, i);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String w: words) {
            char[] letters = w.toLowerCase().toCharArray();
            
            boolean sameRow = true;
            int rowIndex = keyboard.get(letters[0]);
            for (char c: letters) {
                if (rowIndex != keyboard.get(c)) {
                    sameRow = false;
                    break;
                }
            }
            
            if (sameRow) result.add(w);
        }
        
        return result.stream().toArray(String[]::new);
    }
}