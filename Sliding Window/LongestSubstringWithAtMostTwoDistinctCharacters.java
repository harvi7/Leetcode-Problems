// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/

// class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         int n = s.length();
//         if (n < 3) return n;
        
//         int left = 0, right = 0, maxLen = 2;
        
//         HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

//         while (right < n) {
//             hashmap.put(s.charAt(right), right++);
//             if (hashmap.size() == 3) {
//                 int smallestIndex = Collections.min(hashmap.values());
//                 hashmap.remove(s.charAt(smallestIndex));
//                 left = smallestIndex + 1;
//             }
//             maxLen = Math.max(maxLen, right - left);
//         }
//         return maxLen;
//     }
// }

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;
        
        int left = 0, right = 0, maxLen = 2;
        
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        while (right < n) {
            hashmap.put(s.charAt(right), hashmap.getOrDefault(s.charAt(right), 0) + 1);
            right++;
            while (hashmap.size() > 2) {
                if (hashmap.get(s.charAt(left)) > 1)
                    hashmap.put(s.charAt(left), hashmap.get(s.charAt(left)) - 1);            
                else
                    hashmap.remove(s.charAt(left));
 
                left++;
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}