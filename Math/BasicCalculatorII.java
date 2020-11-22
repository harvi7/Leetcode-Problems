// https://www.youtube.com/watch?v=C_jxn1hTn6Q

class Solution {
    public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray())
            if (c != ' ')
                q.offer(c);

        q.offer(' ');

        int num = 0, prev = 0, sum = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();

            if (c >= '0' && c <= '9')
                num = num * 10 + c - '0';
            else {
                switch (prevOp) {
                case '+':
                    sum += prev;
                    prev = num;
                    break;
                case '-':
                    sum += prev;
                    prev = -num;
                    break;
                case '*':
                    prev *= num;
                    break;
                case '/':
                    prev /= num;
                    break;
                }

                num = 0;
                prevOp = c;
            }
        }

        return sum + prev;
    }
}