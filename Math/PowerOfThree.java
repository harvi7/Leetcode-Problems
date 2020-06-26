// https://leetcode.com/problems/power-of-three/discuss/448777/SIMPLE-JAVA-SOLUTIONS

class Solution {
    public boolean isPowerOfThree(int n) {
       int val = (int) Math.round((Math.log(n) / Math.log(3)));
        
        if(n!=0 && (int) Math.round(Math.pow(3, val)) == n)
            return true;
        
        return false; 
    }
}