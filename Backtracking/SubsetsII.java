// https://www.youtube.com/watch?v=lCvL8htQ1iI

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            return results;
        Arrays.sort(nums);
        
        findAllSubsets(nums, results, new ArrayList<>(), 0);
        
        return results;
    }
    
    private void findAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        results.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i -1])
                continue;
            subset.add(nums[i]);
            findAllSubsets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}