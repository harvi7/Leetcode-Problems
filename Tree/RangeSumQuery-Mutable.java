// https://www.youtube.com/watch?v=GURRzAKL1lY
// https://www.youtube.com/watch?v=CWDQJGaN1gY
// https://leetcode.com/problems/range-sum-query-mutable/discuss/75847/Java-7ms-Binary-Index-Tree-solution

class NumArray {
    
    int[] fenTree;
    int[] arr;
    int size;
    
    public NumArray(int[] nums) {
        arr = nums;
        size = nums.length;
        if (size == 0) return;
        fenTree = new int[size + 1];
        
        init();
    }
    
    public void init() {
        if (size == 0) return;
        fenTree[1] = arr[0];
        for(int i = 1; i < size; i++){
            fenTree[i + 1] = fenTree[i] + arr[i];
        }
        
        for(int i = size; i > 0; i--) {
            int parent = getParent(i);
            if (parent >= 0) fenTree[i] -= fenTree[parent];
        }
    }
    
    private int getParent(int index){
        return index - (index & -index);
    }
    
    private int getNext(int index){
        return index + (index & -index);
    }
      
    public int sum(int index) {
        int res = 0;
        index++;
        while (index > 0) {
            res += fenTree[index];
            index = getParent(index);
        }
        return res;
    }
    
    public void increment(int index, int val){
        index++;
        while(index <= size){
            fenTree[index] += val;
            index = getNext(index);          
        }
    }
    
    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;
        increment(i, delta);     
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i-1);
    }
}