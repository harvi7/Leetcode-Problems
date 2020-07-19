// https://www.youtube.com/watch?v=G74W8v2yVjY&list=PLK0ZC7fyo01Jr4CwyEGPB_YYVYqoJS7LR&index=40&t=0s

class Solution {
    public int findSpecialInteger(int[] arr) {
        int quarter = arr.length / 4;
        for (int i = 0; i < arr.length - quarter; i++)
            if (arr[i] == arr[i + quarter])
                return arr[i];
        return -1;
    }
}