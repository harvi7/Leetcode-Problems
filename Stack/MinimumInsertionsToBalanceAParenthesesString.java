// https://www.youtube.com/watch?v=EK3OEfy6lPw
// https://www.youtube.com/watch?reload=9&v=PEKAlnmbBCc

class Solution {
    public int minInsertions(String s) {
        // Stack<Character> stack = new Stack();
        // int insertionsNeeded = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '(') {
        //         if (stack.isEmpty()) {
        //             stack.add(c);   
        //         }
        //         else {
        //             if (stack.peek() != '(') {
        //                 insertionsNeeded++;
        //                 stack.pop();
        //                 stack.pop();
        //             }
        //             stack.add(c);
        //         }
        //     } else {
        //         if (stack.isEmpty()) {
        //             insertionsNeeded++;
        //             stack.add('(');
        //             stack.add(c);
        //         } else {
        //             if (stack.peek() == '(') {
        //                 stack.add(c);
        //             } else {
        //                 stack.pop();
        //                 stack.pop();
        //             }
        //         }
        //     }
        // }
        // if (stack.isEmpty()) {
        //     return insertionsNeeded;
        // } else {
        //     while (!stack.isEmpty()) {
        //         char c = stack.pop();
        //         if (c == '(') {
        //             insertionsNeeded += 2;   
        //         }
        //         else {
        //             insertionsNeeded++;
        //             stack.pop();
        //         }
        //     }
        // }
        // return insertionsNeeded;
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (right % 2 > 0) {
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }
}