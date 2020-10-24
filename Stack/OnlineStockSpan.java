// https://www.youtube.com/watch?v=lGWLBgwd-cw

class StockSpanner {
    Stack<Pair<Integer, Integer>> stk;
    int index;
    
    public StockSpanner() {
        stk = new Stack();
        index = -1;
    }
    
    public int next(int price) {
        index += 1;
        while (!stk.isEmpty() && stk.peek().getValue() <= price) {
            stk.pop();
        }
        
        if (stk.isEmpty()) {
            stk.push(new Pair <Integer,Integer> (index, price));
            return index + 1;
        }

        int result = stk.peek().getKey();
        stk.push(new Pair <Integer,Integer> (index, price));
        return index - result;
    }
}