// https://www.youtube.com/watch?v=Pp5hdsNdqOU

class Solution {
    public boolean canPermutePalindrome(String s) {
        // int[] map = new int[128];
        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     map[s.charAt(i)]++;
        //     if (map[s.charAt(i)] % 2 == 0)
        //         count--;
        //     else
        //         count++;
        // }
        // return count <= 1;
        
        // Using Set
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}