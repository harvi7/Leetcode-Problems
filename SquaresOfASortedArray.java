class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;    
        int positivePointer = 0;
        
        while (positivePointer < len && A[positivePointer] < 0) {
            positivePointer++;
        }
        
        int negativePointer = positivePointer - 1;
        
        int[] sortedSquares = new int[len];
        int counter = 0;
        
        while (negativePointer >= 0 && positivePointer < len) {
            if (A[negativePointer] * A[negativePointer] < A[positivePointer] * A[positivePointer]) {
                sortedSquares[counter++] = A[negativePointer] * A[negativePointer];
                negativePointer--;
            } else {
                sortedSquares[counter++] = A[positivePointer] * A[positivePointer];
                positivePointer++;
            }
        }
            
        while (negativePointer >= 0 ) {
            sortedSquares[counter] = A[negativePointer] * A[negativePointer];
            negativePointer--;
            counter++;
        }

        while (positivePointer < len) {
            sortedSquares[counter] = A[positivePointer] * A[positivePointer];
            positivePointer++;
            counter++;
        }
        return sortedSquares;
    }
}