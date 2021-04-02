public class Stack {
    static class MinMaxStack {
	    Node head; 
        public int peek() {
            return head.val;
    }

    public int pop() {
		int value = head.val;
		head = head.next;
		return value; 
    }

    public void push(Integer number) {
			if(head == null){
				head = new Node(number, number,number);
			} else{
				head = new Node(number, Math.min(number, head.min), Math.max(number,head.max),head);
			}
    }

    public int getMin() {
    
      return head.min;
    }

    public int getMax() {
      
      return head.max;
    }
    private class Node{
        Integer node;
        Integer min;
        Integer max;
        Integer val; 
        Node next;
        private Node(Integer val, int min, int max, Node next){
            this.val = val;
            this.min = min;
            this.max = max;
            this.next = next;
        }
        private Node(Integer val, Integer min, Integer max){
            this(val,min,max,null);
        }
    }
}
