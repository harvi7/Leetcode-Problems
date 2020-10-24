class Solution {
    public List<String> generatePossibleNextMoves(String s) {
//         List<String> possibleStates = new ArrayList<>();
//         if (s == null || s.length() < 2) return possibleStates;
//         int i = 0;
//         while (i < s.length()) {
//             int nextMove = i == 0 ? s.indexOf("++") : s.indexOf("++", i);
//             if (nextMove == -1) 
//                 return possibleStates;
            
//             String nextState = s.substring(0, nextMove) + "--" + s.substring(nextMove + 2);
//             possibleStates.add(nextState);
//             i = nextMove + 1;
//         }
//         return possibleStates;
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == s.charAt(i)) {
                str.replace(i, i+2, "--");
                res.add(str.toString());
                str.replace(i, i+2, "++");
            }
        }
        return res;
    }
}