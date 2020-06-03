class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), 1, n, k);
		return result;
	}
	public static void helper(List<List<Integer>> result, List<Integer> currentList, int start, int n, int k) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(currentList));
			return;
		}
		for(int i=start;i<=n;i++) {
			currentList.add(i);
			helper(result, currentList, i + 1, n, k - 1);
			currentList.remove(currentList.size() - 1);
		}
	}
}