// https://www.youtube.com/watch?v=vbM41Zql228

class Solution {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (k == size) return "0";
        
        Stack<Character> stack = new Stack();
        int counter = 0;
        while (counter < size) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
        }    
        while (k > 0) {
                stack.pop();
                k--;
        }
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {        
            char currChar = stack.pop();
            sb.append(currChar);
        } 
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0')
            sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}