// https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82241/AC-solution-using-Java-HashMap

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < nums1.length; i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
           res[i] = result.get(i);

        return res;
    }
}