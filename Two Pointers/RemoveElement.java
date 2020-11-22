// https://www.youtube.com/watch?v=SKI8IirQZgo

class Solution {
    public int removeElement(int[] nums, int val) {
//         for(int i=0; i<nums.length-1; i++){
//             for(int j=0; j<nums.length-i-1; j++){
//                 if(nums[j]==val){
//                     int temp = nums[j];
//                     nums[j] = nums[j+1];
//                     nums[j+1] = temp;
//                 }
//             }
//         }
        
//         int flag = 0;
        
//         int count=0;
        
//         while(count<nums.length){
//             if(nums[count]!=val)
//                 count++;
//             else
//                 break;
//         }
//         return count;
        
//4ms
        
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
//3ms
    }
}