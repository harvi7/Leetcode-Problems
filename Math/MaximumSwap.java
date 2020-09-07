// https://www.youtube.com/watch?v=YM4_hj7AWrI

class Solution {
    public int maximumSwap(int num) {
        char[] numChars = Integer.toString(num).toCharArray();
        int[] lastIndex = new int[10];
        for (int i = 0; i < numChars.length; i++) {
            lastIndex[numChars[i] - '0'] = i;
        }    

        for (int i = 0; i < numChars.length; i++) {
            for (int d = 9; d > numChars[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    swap(numChars, lastIndex[d], i);
                    return Integer.valueOf(new String(numChars));
                }
            }
        }
        return num;
    }
    
    private void swap(char[] numChars, int i, int j) {
        char tmp = numChars[i];
        numChars[i] = numChars[j];
        numChars[j] = tmp;
    }
}