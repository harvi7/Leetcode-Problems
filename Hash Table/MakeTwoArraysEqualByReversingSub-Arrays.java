// https://www.youtube.com/watch?v=7YoDfM4RbZs

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> _map = new HashMap();
        for (int t : target) {
            _map.put(t, _map.getOrDefault(t, 0) + 1);
        }
        
        for (int a : arr) {
            if (_map.containsKey(a) && _map.get(a) > 0)
                _map.put(a, _map.get(a) - 1);
            else
                return false;
        }
        return true;
    }
}