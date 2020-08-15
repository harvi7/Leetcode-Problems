// https://leetcode.com/problems/find-k-closest-elements/solution/
// https://leetcode.com/problems/find-k-closest-elements/discuss/106426/JavaC%2B%2BPython-Binary-Search-O(log(N-K)-%2B-K)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
		if (x <= arr[0])
			return Arrays.stream(arr, 0, k).boxed().collect(Collectors.toList());
		else if (arr[n - 1] <= x)
			return Arrays.stream(arr, n - k, n).boxed().collect(Collectors.toList());
        else {
            int left = 0, right = arr.length - k;
            while (left < right) {
                int mid = (left + right) / 2;
                if (x - arr[mid] > arr[mid + k] - x)
                    left = mid + 1;
                else
                    right = mid;
            }
            return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
        }
    }
}