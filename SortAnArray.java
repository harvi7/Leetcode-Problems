class Solution {
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        //bubbleSort(nums);
        //selectionSort(nums);
        //insertionSort(nums);
        List<Integer> res = new ArrayList<Integer>();
        for (Integer num: nums) {
            res.add(num);
        }
        return res;
        //return mergeSort(nums);
    }
    
//     private static int[] mergeSort(int[] nums){
//         if(nums.length <= 1)
//             return nums;
//         int[] left = new int[nums.length/2];
//         int[] right = new int[nums.length - left.length];
//         for(int i =0; i < left.length; ++i){
//             left[i] = nums[i];
//             right[i] = nums[i + left.length];
//         }
//         if(right.length > left.length)
//             right[right.length - 1] = nums[nums.length - 1];
//         int[] leftResult = mergeSort(left);
//         int[] rightResult = mergeSort(right);
//         return merge(leftResult, rightResult);
//     }
    
//     private static int[] merge(int[] a, int[] b){
//         int ai = 0, bi = 0, ci = 0;
//         int[] c = new int[a.length + b.length];
//         while(ai < a.length && bi < b.length){
//             if(a[ai] < b[bi])
//                 c[ci++] = a[ai++];
//             else
//                 c[ci++] = b[bi++];
//         }
//         while(ai < a.length)
//             c[ci++] = a[ai++];
//         while(bi < b.length)
//             c[ci++] = b[bi++];
//         return c;
//     }
    
    private void quickSort(int[] nums, int start, int end){
        if(start >= end) return;
        int pIndex = partition(nums, start, end);
        quickSort(nums, start, pIndex - 1);
        quickSort(nums, pIndex + 1, end);
    }
    
    private int partition(int[] nums, int start, int end){
        int pIndex = start;
        int pivot = nums[end];
        for(int i = start; i < end; i++){
            if(nums[i] < pivot){
                int temp = nums[pIndex];
                nums[pIndex] = nums[i];
                nums[i] = temp;
                pIndex ++;
            }
        }
        nums[end] = nums[pIndex];
        nums[pIndex] = pivot;
        return pIndex;
    }
    
//     private void bubbleSort(int[] nums){
//         for(int i = 0; i < nums.length - 1; i++){
//             for(int j = 0; j < nums.length - 1; j++){
//                 if(nums[j] > nums[j + 1]){
//                     int temp = nums[j];
//                     nums[j] = nums[j + 1];
//                     nums[j + 1] = temp;
//                 }
//             }
//         }
//     }
    
//     private void selectionSort(int[] nums){
//         for(int i = 0; i < nums.length - 1; ++i){
//             int cur = i;
//             for(int j = i + 1; j < nums.length; ++j){
//                 if(nums[j] < nums[cur])
//                     cur = j;
//             }
//             int temp = nums[cur];
//             nums[cur] = nums[i];
//             nums[i] = temp;
//         }
//     }
    
//     private void insertionSort(int[] nums){
//         for(int i = 0; i < nums.length; ++i){
//             int temp = nums[i];
//             int j = i - 1;
//             while(j >= 0 && nums[j] > temp){
//                 nums[j + 1] = nums[j];
//                 j--;
//             }
//             nums[j + 1] = temp;
//         }
//     }
}
