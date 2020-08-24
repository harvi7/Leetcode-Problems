// https://www.youtube.com/watch?v=mnpZgPe4d7w
// https://leetcode.com/problems/my-calendar-i/solution/

class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}