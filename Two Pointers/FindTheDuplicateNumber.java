// https://www.youtube.com/watch?v=i4kBcvA3OV4
// https://www.youtube.com/watch?v=-YiQZi3mLq0

class Solution {
    public int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];
        
        slowPointer = nums[slowPointer];
        fastPointer = nums[nums[fastPointer]];
        
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }
        
        int aPointer = nums[0];
        int bPointer = slowPointer;
        
        while (aPointer != bPointer) {
            aPointer  = nums[aPointer];
            bPointer = nums[bPointer];
        }
        return aPointer;
    }
}