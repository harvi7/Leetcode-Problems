// https://www.youtube.com/watch?v=tvioNeOXRUg&ab_channel=NickWhite

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = new int[26];
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> result = new ArrayList();
        
        for (String a: A) {
            int[] aCount = count(a);
            boolean valid = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) result.add(a);
        }

        return result;
    }

    public int[] count(String S) {
        int[] result = new int[26];
        for (char c: S.toCharArray())
            result[c - 'a']++;
        return result;
    }
}