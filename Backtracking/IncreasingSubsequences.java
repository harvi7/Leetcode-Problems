// https://leetcode.com/problems/increasing-subsequences/discuss/818139/JAVA-backtracking-solution

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    HashSet<List<Integer>> s = new HashSet<>();
    
    public void findAll(int[] nums, List<Integer> temp, int index){
        if (index > nums.length) return;
        if (temp.size() >= 2) {
            List<Integer> clone = new ArrayList<>(temp);
            s.add(clone);
        }
        
        for (int i = index; i < nums.length; i++){
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                findAll(nums, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        findAll(nums, new ArrayList<>(), 0);
        for (List<Integer> element : s){
            result.add(element);
        }
        return result;
    }
}
