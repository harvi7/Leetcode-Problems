class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        String temp = "";
        
        if (strs.length == 0) return temp;
        
        int l = strs[0].length();
        temp = strs[0];
        
        for (String str : strs) {
            if (str.length() < l){
                l = str.length();
                temp = str;
            }
        }
        
        int flag = 0;
        
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            flag = 0;
            for (String str : strs) {
                if (!(str.charAt(i) == c)) {
                    flag = 0;
                    break;
                }
                else
                flag = 1;
            }
            if (flag == 1) output = output + c;
            else break;
        }
            
        //System.out.println(l+" "+temp+" "+output);
        return output;
    }
}