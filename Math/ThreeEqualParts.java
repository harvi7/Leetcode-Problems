// https://www.youtube.com/watch?v=QzylCxWYdBE

class Solution {
    private static final int[] IMPOSSIBLE = new int[] {-1, -1};
    
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int oneCount = 0; 

        for (int i : arr) if (i == 1) oneCount++;
        
        if (oneCount % 3 != 0) return IMPOSSIBLE;
        if (oneCount == 0) return new int[]{0, n - 1};
        
        int k = oneCount / 3; 

        int i1 = -1, i2 = -1, i3 = -1, j1 = -1, j2 = -1,j3 = -1;
        int currCount = 0; 
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                currCount += 1;
                if (currCount == 1) i1 = i;
                if (currCount == (k + 1)) i2 = i;
                if (currCount == (2 * k + 1)) i3 = i;
                
                if (currCount == k) j1 = i;
                if (currCount == 2 * k) j2 = i;
                if (currCount == 3 * k) j3 = i;
            }
        }
        
        int start = i1, mid = i2,end = i3;
        while (k-- > 0 && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;
            mid++;
            end++;
        }
        
        if (k >= 0) return IMPOSSIBLE;
      

        int first = 0, second = 0, third = 0;
        first = i2 - j1 - 1;
        second = i3 - j2 - 1;
        third = n - j3 - 1;
        
        if (third > Math.min(first, second)) return IMPOSSIBLE;
        
        return new int[]{j1 + third, j2 + third + 1};
    }
}