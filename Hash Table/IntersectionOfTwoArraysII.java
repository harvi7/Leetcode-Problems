// https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82241/AC-solution-using-Java-HashMap
// https://www.youtube.com/watch?v=lKuK69-hMcc

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                map.put(num, count - 1);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result)
           res[i++] = num;

        return res;
    }
}