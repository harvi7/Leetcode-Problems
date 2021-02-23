// https://leetcode.com/problems/design-hit-counter/solution/

class HitCounter {
    
    private int total;
    private Deque<Pair<Integer, Integer>> hits; 
    
    /** Initialize your data structure here. */
    public HitCounter() {
        this.total = 0;
        this.hits = new LinkedList<Pair<Integer, Integer>>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
            this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            int prevCount = this.hits.getLast().getValue();
            this.hits.removeLast();
            this.hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        this.total++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.getFirst().getKey();
            if (diff >= 300) {
                // Decrement total by the count of the oldest timestamp
                this.total -= this.hits.getFirst().getValue();
                this.hits.removeFirst();
            }
            else break;
        }
        return this.total;
    }
}