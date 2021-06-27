// https://leetcode.com/problems/pascals-triangle/solution/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        
        if (numRows == 1) return res;
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> cur = new ArrayList<>(i);
            
            cur.add(1);
                  
            for (int j = 1; j < i - 1; ++j) {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}