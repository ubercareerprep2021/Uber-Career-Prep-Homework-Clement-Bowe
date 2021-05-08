public class Stack {
	    Node head;
        private int size;
        public Stack(){
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
				head = new Node(number, Math.max(number,head.max),head);
			}
            size++;
    }



    public int getMax() {
      
      return head.max;
    }
    private class Node{
        Integer max;
        Integer val; 
        Node next;
        private Node(Integer val, int max, Node next){
            this.val = val;
            this.max = max;
            this.next = next;
        }
        private Node(Integer val, Integer max){
            this(val, max, null);
        }
    }
}
