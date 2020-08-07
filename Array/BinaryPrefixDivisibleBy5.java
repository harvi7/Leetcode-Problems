// https://www.youtube.com/watch?reload=9&v=SfjTHS80C8M

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = A[0];
        boolean check = num % 5 == 0 ? true : false;
        res.add(check);
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 1) num = num * 2 + 1;
            else num = num * 2;
            if (num % 5 == 0) res.add(true);
            else res.add(false);
            num %= 5;
        } 
        return res;
    }
}