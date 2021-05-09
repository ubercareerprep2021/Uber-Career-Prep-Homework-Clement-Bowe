public class Stack {
	    Node head;
        private int size;
        public Stack(){
            head = null;
            size = 0;
        } 
        public int peek() {
            return head.val;
        }
    public int pop() {
        try{
		    int value = head.val;
		    head = head.next;
            size--;
		    return value;
        }
        catch (Exception e){
            return -1;
        } 
    }

    public void push(Integer number) {
			if(head == null){
				head = new Node(number, number);
			} else{
				head = new Node(number, Math.min(number,head.min),head);
			}
            size++;
    }

    public int getMin() {
      return head.min;
    }
    
    private class Node{
        Integer min;
        Integer val; 
        Node next;
        private Node(Integer val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
        private Node(Integer val, Integer max){
            this(val, max, null);
        }
    }
}
