// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/362940/Java-Solution

class Solution {
    public boolean isValid(String s) {
        // if (s.equals(""))
		// 	return true;
		// else {
		// 	if (s.contains("abc")) {
		// 		s = s.replace("abc", "");
		// 		return isValid(s);
		// 	} else
		// 		return false;
        // }
        Stack<String> stack = new Stack();
        char[] arr = s.toCharArray();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            char next = arr[i];
            if (next == 'a') {
                stack.push("a");
            } else if (next == 'b' && !stack.isEmpty() && stack.peek().equals("a"))  {
                stack.pop();
                stack.push("ab");
            } else if (next == 'c' && !stack.isEmpty() && stack.peek().equals("ab"))  {
                stack.pop();
            } else
                return false;
        }
        return stack.isEmpty();
    }
}