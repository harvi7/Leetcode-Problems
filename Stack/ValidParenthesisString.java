// https://www.youtube.com/watch?v=KuE_Cn3xhxI

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>(), star = new Stack<>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') open.push(i);
            else if (s.charAt(i) == '*')
                star.push(i);
            else {
                if (!open.empty()) open.pop();
                else if (!star.empty()) star.pop();
                else return false;
            }
        }
        
        while (!open.empty()) {
            if (star.empty()) return false;
            else if(open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }
            else return false;
        }
        return true;
    }
}