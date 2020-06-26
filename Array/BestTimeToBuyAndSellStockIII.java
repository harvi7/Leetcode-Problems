// https://www.youtube.com/watch?v=gVavspgEHyM

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;               
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;               
        for(int p : prices) {
            firstBuy = Math.max(firstBuy, -p);
            firstSell = Math.max(firstSell, p + firstBuy);
            secondBuy = Math.max(secondBuy, firstSell - p);      
            secondSell = Math.max(secondSell, secondBuy + p);   
        }
        return secondSell;
    }
}