// https://leetcode.com/problems/power-of-four/discuss/678134/Maths-logic-explained-with-proof
// https://leetcode.com/problems/power-of-four/discuss/676909/Simple-java-solution100-fasterwithout-pow-functiono(1)-time

class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0 && (num & (num - 1)) == 0) && (num - 1) % 3 == 0;
        // if(num<=0) return false;
        // int i = num & (num-1);
        // int digit = (int)(Math.log(num)/Math.log(2));
        // return i==0 && digit%2==0;
    }
}