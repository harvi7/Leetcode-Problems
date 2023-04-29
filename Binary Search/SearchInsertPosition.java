class Solution {
    public int searchInsert(int[] nums, int target) {
        int output = 0;       
        int l = 0, h = nums.length - 1;
        
        
        while (l < h) {
            int mid = (l + h) / 2;
            
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                h = mid -1;
            else
                return mid;            
        }
        
        if (target > nums[l])
            return l + 1;
        else
            return l;
        
    }
}