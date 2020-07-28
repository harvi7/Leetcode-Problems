// https://www.youtube.com/watch?v=VWVv1zf30gE

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }

        res.addFirst(dep);
    }
}