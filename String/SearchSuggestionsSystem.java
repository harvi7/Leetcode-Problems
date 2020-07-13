// https://www.youtube.com/watch?v=eVQiFuJRfsU

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        int n = products.length;
        int lo = 0, hi = n - 1;
        int len = searchWord.length();
        
        Arrays.sort(products);
        for (int i = 0; i < len; i++) {
            while ((lo <= hi) && (products[lo].length() <= i ||
                                 products[lo].charAt(i) != searchWord.charAt(i))) {
                lo++;
            }
            
            while ((lo <= hi) && (products[hi].length() <= i || 
                                 products[hi].charAt(i) != searchWord.charAt(i))) {
                hi--;
            }
            
            int min = Math.min(lo + 3, hi + 1);
            List<String> list = new ArrayList<>();
            for (int j = lo; j < min; j++) {
                list.add(products[j]);
            }
            
            res.add(list);
        }
        
        return res;
    }
}