// https://www.youtube.com/watch?v=8ZOW6NmF1_8

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandiesSet = new HashSet<>();
        for (int candy: candyType) {
            uniqueCandiesSet.add(candy);
        }
        return Math.min(uniqueCandiesSet.size(), candyType.length / 2);
    }
}