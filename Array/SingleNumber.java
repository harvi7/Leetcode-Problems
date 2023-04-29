class Solution {
    public int singleNumber(int[] nums) {
        
//         HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
//         for(int i : nums){
//             if(map.containsKey(i))
//                 map.put(i, map.get(i)+1);
//             else
//                 map.put(i,1);
            
//         }
        
//         for(int key:map.keySet()){
//              if(map.get(key) == 1) {
//                 return key;
//             }
//         }
        
//         return -1;
//9ms        
//         int sum=0;
        
//         Set<Integer> setUniqueNumbers = new LinkedHashSet<Integer>();
//         for(int x : nums) {
//             setUniqueNumbers.add(x);
//             sum += x;
//         }
        
//         int sum1 =0;
        
        
//         for(Integer x : setUniqueNumbers) {
//             sum1 += x;    
//         }
        
//         return (2*sum1)-sum;
//         HashMap<Integer, Integer> hash_table = new HashMap<>();

//         for (int i : nums) {
//             hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
//         }
//         for (int i : nums) {
//             if (hash_table.get(i) == 1) return i;
//         }
//         return 0;
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
    
}