// https://leetcode.com/problems/max-points-on-a-line/discuss/355703/O(N2)-TIME-JAVA-SOLUTION-%2B-EXPLANATION-GCD
// https://www.youtube.com/watch?v=KqZV0XfKQks

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (points == null)
            return 0;
        else if (netscape <= 2)
            return n;

        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            int[] a = points[i];
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = y + "/" + x; 
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            int localMax = 0;
            for (int value : map.values()) {
                localMax = Math.max(localMax, value);
            }

            max = Math.max(max, 1 + localMax + same);
        }
        return max;
    }
    
    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private int generateGcd(int a, int b) { // Euclid's Greatest Common Divisor (GCD) Algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}