// https://www.youtube.com/watch?v=tbtXPKkA2Zw&list=PLK0ZC7fyo01Jr4CwyEGPB_YYVYqoJS7LR&index=45

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String str : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0)
                    even[str.charAt(i) - 'a']++;
                else
                    odd[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(odd) + Arrays.toString(even);
            seen.add(key);
        }
        return seen.size();
    }
}