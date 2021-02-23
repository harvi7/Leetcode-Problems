// https://leetcode.com/problems/group-anagrams/solution/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // if (strs == null || strs.length == 0)
        //     return Collections.EMPTY_LIST;
        // List<List<String>> res = new ArrayList<>();
        // Map<String, List<String>> m = new HashMap<>();
        // for (String str : strs) {
        //     int[] count = new int[26];
        //     StringBuilder sb = new StringBuilder();
        //     for (char c : str.toCharArray())
        //         ++count[c - 'a'];
        //     for (int c : count)
        //         sb.append(c);
        //     String t = sb.toString();
        //     if (!m.containsKey(t))
        //         m.put(t, new ArrayList<>());
        //     m.get(t).add(str);
        // }
        // for (List<String> list : m.values())
        //     res.add(list);
        // return res;
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}