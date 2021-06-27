// https://www.youtube.com/watch?v=uEDL-o3ws9Q

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2); 

        int count = arr1.length;
        for (int val : arr1) {
            int arr2_index = searchForClosest(arr2, val);
            int difference;
 
            if (arr2_index == 0) {
                difference = Math.abs(val - arr2[arr2_index]);
            } else {
                difference = Math.min(Math.abs(val - arr2[arr2_index - 1]), Math.abs(val - arr2[arr2_index]));
            }
            if (difference <= d)
                count--;
        }
        return count;
    }

    public static int searchForClosest(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) 
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}