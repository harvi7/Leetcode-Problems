// https://www.youtube.com/watch?v=JeE6KcuqSKg

class TwoSum {
    private HashMap<Integer, Integer> numCounts;
    /** Initialize your data structure here. */
    public TwoSum() {
        numCounts = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        numCounts.put(number, numCounts.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : numCounts.keySet()) {
            int target = value - key;
            if (numCounts.containsKey(target)) {
                if (key == target && numCounts.get(key) < 2)
                    continue;
                return true;
            }
        }
        return false;
    }
}
