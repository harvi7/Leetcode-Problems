// https://www.youtube.com/watch?reload=9&v=p0P1JNHAB-c

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missed = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                missed += arr[0] - 1;
                if (missed >= k)
                    return k;
            } else {
                missed += arr[i] - arr[i - 1] -1;
                if (missed >= k) {
                    missed -= arr[i] - arr[i - 1] -1;
                    int result = arr[i - 1];
                    while (missed++ < k)
                        result++;
                    return result;
                }
            }
        }
        int result = arr[arr.length - 1];
        while (missed++ < k)
            result++;
        return result;
    }
}