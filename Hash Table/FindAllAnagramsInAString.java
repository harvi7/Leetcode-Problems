// https://www.youtube.com/watch?v=fvEw13A5O1o
// https://leetcode.com/problems/find-all-anagrams-in-a-string/solution/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // List<Integer> result = new ArrayList();
        // if (s.length() == 0 || s == null) return result;
        
        // int[] charCounts = new int[26];
        // for (char c : p.toCharArray()) {
        //     charCounts[c - 'a']++;
        // }
        
        // int left = 0;
        // int right = 0;
        // int count = p.length();
        
        // while (right < s.length()) {
            
        //     if (charCounts[s.charAt(right++) - 'a']-- >= 1) count--;
        //     if (count == 0) result.add(left);
        //     if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0)
        //         count++;
        // }
        // return result;
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];

        for (char ch : p.toCharArray()) {
          pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        for (int i = 0; i < ns; ++i) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= np) 
                sCount[s.charAt(i - np) - 'a']--;
            if (Arrays.equals(pCount, sCount)) 
                output.add(i - np + 1);
            }
        }
        return output;
    }
}