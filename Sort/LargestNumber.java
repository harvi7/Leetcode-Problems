// https://www.youtube.com/watch?v=AKZaaVqjVl4

class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strArr[i] = Integer.toString(nums[i]);
        
        Arrays.sort(strArr, new Comparator<String>(){
           public int compare(String a, String b) {
               String o1 = a + b;
               String o2 = b + a;
               return o2.compareTo(o1);
           } 
        });
        
        if (strArr[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : strArr)
            sb.append(s);
        
        return sb.toString();
    }
}