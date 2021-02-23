// https://www.youtube.com/watch?v=wAyrtLAeWvI
// https://www.youtube.com/watch?v=snOaKR2xgZg  
// https://leetcode.com/problems/powx-n/solution/

class Solution {
    public double myPow(double x, int n) {
        // if (n == Integer.MIN_VALUE){
        //     x = x * x;
        //     n = n / 2;
        // }
        // if (n < 0) {
        //     n = -n;
        //     x = 1 / x;
        // }        
        // return helper(x, n);
        
        // Iterative
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
    
    // private double helper(double x, int n) {
    //     if (n == 0) return 1;
    //     else if (n % 2 == 0) {
    //         double y = helper(x, n / 2);
    //         return y * y;
    //     }
    //     else
    //         return x * helper(x, n - 1);
    // }
}
