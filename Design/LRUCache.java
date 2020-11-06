// https://www.youtube.com/watch?v=NDpwj0VWz1U

class LRUCache {

    DNode head;
    DNode tail;
    Map<Integer, DNode> lruMap;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        lruMap = new HashMap<>();
        size = 0;
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (lruMap.containsKey(key)) {
            bringToFront(lruMap.get(key));      // bring node to the front
            return lruMap.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(lruMap.containsKey(key)) {
            DNode node = lruMap.get(key);
            node.value = value; 
            bringToFront(lruMap.get(key));      // bring node to the front  
        } else {
            size++;
            if (size > capacity) {
                DNode lastNode = tail.prev;     // pop tail
                removeNode(lastNode);
                lruMap.remove(lastNode.key);    //remove it from the map
                size--;                         //decrease the size
            }
            DNode node = new DNode(key, value);
            lruMap.put(key, node);
            addNode(node);// add node
        }
    }
    
    public void addNode(DNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }
    
    public void bringToFront(DNode node) {
        removeNode(node);
        addNode(node);
    }
    
    class DNode {
        int key;
        int value;
        DNode next;
        DNode prev;
        
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}