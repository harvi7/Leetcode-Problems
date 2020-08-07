// https://leetcode.com/problems/construct-the-rectangle/discuss/310341/Algorithm-workout-with-Example

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) 
            w--;
        return new int[]{area / w, w};
    }
}