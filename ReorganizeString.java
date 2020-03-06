// https://www.youtube.com/watch?v=zaM_GLLvysw

class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : S.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(current) > 0)
                maxHeap.add(current);
            if (counts.get(next) > 0)
                maxHeap.add(next); 
        }
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1)
                return "";
            result.append(last);
        }
        return result.toString();

        
// better solution Leetcode Solution 1
//         int N = S.length();
//         int[] counts = new int[26];
//         for (char c: S.toCharArray()) counts[c-'a'] += 100;
//         for (int i = 0; i < 26; ++i) counts[i] += i;
//         //Encoded counts[i] = 100*(actual count) + (i)
//         Arrays.sort(counts);

//         char[] ans = new char[N];
//         int t = 1;
//         for (int code: counts) {
//             int ct = code / 100;
//             char ch = (char) ('a' + (code % 100));
//             if (ct > (N+1) / 2) return "";
//             for (int i = 0; i < ct; ++i) {
//                 if (t >= N) t = 0;
//                 ans[t] = ch;
//                 t += 2;
//             }
//         }

//         return String.valueOf(ans);
        
    }
}