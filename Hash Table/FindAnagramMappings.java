// https://leetcode.com/problems/find-anagram-mappings/solution/

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> D = new HashMap();
        for (int i = 0; i < nums2.length; ++i)
            D.put(nums2[i], i);

        int[] ans = new int[nums1.length];
        int t = 0;
        for (int x : nums1)
            ans[t++] = D.get(x);
        return ans;
    }
}