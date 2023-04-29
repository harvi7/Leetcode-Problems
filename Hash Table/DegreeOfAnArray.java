// https://www.youtube.com/watch?v=7wT5sFELf7Q

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap();
        int degree = 0;
        
        HashMap<Integer, Integer> firstSeen = new HashMap();
        int minLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            if (counts.get(nums[i]) > degree) {
                degree = counts.get(nums[i]);
                minLength = i - firstSeen.get(nums[i]) + 1;
            } else if (counts.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
            }          
        }
        
        return minLength;
    }
}