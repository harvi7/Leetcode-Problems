// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/452970/JAVA-EASY-Solution-with-EXPLANATION!-(MUST-READ)

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) + head.next.val;
            head = head.next;    
        }
        return num;
    }
}