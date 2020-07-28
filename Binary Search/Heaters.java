class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int candidate = 0;
        
        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if (index >= 0) continue;
            int pos = -(index + 1);
            int leftDis = pos > 0 ? houses[i] - heaters[pos - 1] : Integer.MAX_VALUE;
            int rightDis = pos < heaters.length ? heaters[pos] - houses[i] : Integer.MAX_VALUE;
            candidate = Math.max(candidate, Math.min(leftDis, rightDis));
        }
        return candidate;
    }
}