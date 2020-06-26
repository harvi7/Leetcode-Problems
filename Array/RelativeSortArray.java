class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int[] count = new int[1001];
        
        for (int x : arr1) count[x]++;
        int i = 0;
        
        for (int x : arr2) {
            while (count[x] != 0) {
                res[i++] = x;
                count[x]--;
            }
        }
        
        for (int j = 0; j <= 1000; j++) {
            while (count[j] != 0) {
                res[i++] = j;
                count[j]--;
            }
        }
        return res;
        
        
        // if (0 <= arr1[i], arr[i]  <= 1000) constraint is not present
//         Map<Integer, Integer> pos = new HashMap<>();
        
//         for(int i=0; i < arr2.length; i++)
//             pos.put(arr2[i], i);
//         List<Integer> list = new ArrayList<>();
//         for(int n : arr1)
//             list.add(n);
        
//         Collections.sort(list, new Comparator<Integer>(){
//             public int compare(Integer n1, Integer n2){
//                 if(!pos.containsKey(n1) && !pos.containsKey(n2))
//                     return n1-n2;
//                 else if(pos.containsKey(n1) && pos.containsKey(n2))
//                     return pos.get(n1)-pos.get(n2);
//                 else{
//                     if(pos.containsKey(n1))
//                         return n1;
//                     else
//                         return n2;
//                 }
//             }
//         });
//         return list.stream().mapToInt(Integer::intValue).toArray();
    }
}