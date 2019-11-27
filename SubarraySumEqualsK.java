class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> arrSums = new HashMap(); 
        arrSums.put(0, 1);
        int sum  = 0, result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //if (arrSums.containsKey(sum - k))
            result += arrSums.getOrDefault(sum - k, 0);
            arrSums.put(sum, arrSums.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}