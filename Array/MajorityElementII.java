// https://leetcode.com/problems/majority-element-ii/
// https://leetcode.com/problems/majority-element-ii/discuss/543672/BoyerMoore-majority-vote-algorithm-EXPLAINED-(with-pictures)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            return res;
        
        int cand1 = 1;
        int cand2 = 1; 
        int vote1 = 0;
        int vote2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand1)
                vote1++;
            else if (nums[i] == cand2)
                vote2++;
            else if (nums[i] == cand2)
                vote2++;
            else if (vote1 == 0) {
                cand1 = nums[i];
                vote1++;
            } else if (vote2 == 0) {
                cand2 = nums[i];
                vote2++;
            } else {
                vote1--;
                vote2--;
            }       
        }
        
        int count1 = 0; 
        int count2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == cand1)
                count1++;
            else if (nums[i] == cand2)
                count2++;
        }
        if (count1 > nums.length / 3) 
            res.add(cand1);
        if (count2 > nums.length / 3) 
            res.add(cand2);
        return res;    
    }
}