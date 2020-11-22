// https://www.youtube.com/watch?v=AOD1VYQnUP4

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> res = new ArrayList<>(s);
        return "/" + String.join("/", res);    
    }
}