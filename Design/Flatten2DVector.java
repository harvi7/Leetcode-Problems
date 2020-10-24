import java.util.NoSuchElementException;

class Vector2D {
//     private List<Integer> nums = new ArrayList<>();
//     private int position = 0;
    
//     public Vector2D(int[][] v) {
//         for (int[] innerVector : v) {
//             for (int num : innerVector) {
//                 nums.add(num);
//             }
//         }
//     }
    
//     public int next() {
//         if (!hasNext()) throw new NoSuchElementException();
//         int result = nums.get(position);
//         position++;
//         return result;
//     }
    
//     public boolean hasNext() {
//         return position < nums.size();
//     }
    
    private int row;
    private int col;
    private int[][] v;

    public Vector2D(int[][] v) {
        this.v = v;
    }
    
    public int next() {
        updateCoors();
        return v[row][col++];
    }
    
    public boolean hasNext() {
        updateCoors();
        return row != v.length;
    }
    
    private void updateCoors() {
        while (row < v.length && col == v[row].length) {
            row++;
            col = 0;
        } 
    }
}
