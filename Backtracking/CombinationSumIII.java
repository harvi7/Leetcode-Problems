// https://leetcode.com/problems/combination-sum-iii/solution/
// https://leetcode.com/problems/combination-sum-iii/discuss/815442/Java-or-Simple-Solution-Time-100

class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum3(int k, int n) {
        results = new ArrayList<>();
        backtrack(n, k, new LinkedList<Integer>(), 0);
        return results;
    } 
    
    private void  backtrack(int remain, int k, LinkedList<Integer> comb, int index) {

        if (comb.size() == k){
            if (remain == 0)
                results.add(new ArrayList<>(comb));
            return;
        }
        for (int i = index; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1);
            comb.removeLast();
        }
    }
}