// https://www.youtube.com/watch?v=AFtXLUn_TZg

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList();
        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 1; j <= i; j++) {
                if (arr[j] == i + 1){
                    flip(arr, j);
                    result.add(j + 1);
                    break;
                }
            }
            flip(arr, i);
            result.add(i + 1);
        }
        return result;
    }
    
    private void flip(int[] arr, int idx) {
        for(int i = 0; i <= idx / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[idx - i];
            arr[idx - i] = tmp;
        }
    }
}