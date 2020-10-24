// https://www.youtube.com/watch?v=DexvMx0GsKY

class Solution {
    private int minPrice;
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice = directlyBuy(price, needs);
        helper(price, special, 0, needs, 0);
        return minPrice;   
    }
    
    private boolean canUse(List<Integer> offer, List<Integer> needs) {
        int n = needs.size();
        for (int i = 0; i < n; i++) {
            if (offer.get(i) > needs.get(i)) return false;
        }
        return true;
    }
    
    private void helper(List<Integer> price, List<List<Integer>> special, int index, List<Integer> needs, int used) {
        if (used >= minPrice) return;

        if (index == special.size()) {
            used += directlyBuy(price, needs);
            if (used < minPrice) minPrice = used;
            return;
        }

        List<Integer> offer = special.get(index);
        int n = needs.size();

        if (canUse(offer, needs)) {
            List<Integer> updatedNeeds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                updatedNeeds.add(needs.get(i) - offer.get(i));
            }

            helper(price, special, index, updatedNeeds, used + offer.get(n));
        }

        helper(price, special, index + 1, needs, used);
    }
    
    private int directlyBuy(List<Integer> price, List<Integer> needs) {
        int total = 0;
        int n = price.size();
        for (int i = 0; i < n; i++) {
            total += price.get(i) * needs.get(i);
        }

        return total;
    }
}