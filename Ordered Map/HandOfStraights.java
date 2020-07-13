// https://www.youtube.com/watch?v=6JF-fxiDjIc

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> cardCounts = new TreeMap();
        for (int card : hand)
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);    
        
        while (cardCounts.size() > 0) {
            int firstCard = cardCounts.firstKey();
            for (int i = firstCard; i < firstCard + W; i++) {
                if (!cardCounts.containsKey(i)) return false;
                if (cardCounts.get(i) == 1) cardCounts.remove(i);
                else cardCounts.replace(i, cardCounts.get(i) - 1);
            }
        }
        return true;
    }
}