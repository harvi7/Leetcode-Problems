/**
class MinStack {
    private Stack<Integer> s1, s2;
     initialize your data structure here. 
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= s2.peek()) s2.push(x);
    }
    
    public void pop() {
        int x = s1.pop();
        if(x == s2.peek()) s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
**/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class Node{
    int data, min;
    Node next;
    
    Node(int x){
        this.data = this.min = x;
        this.next = null;
    }
}

class MinStack {
    private Node head;
    public void push(int x) {
        if (head == null){
            head = new Node(x);
            return;
        }
        Node newNode = new Node(x);
        newNode.min = Math.min(newNode.min, head.min);
        newNode.next = head;
        head = newNode;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}