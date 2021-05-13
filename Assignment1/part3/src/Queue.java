public class Queue{

    private Node head = new Node(-1);
    private Node tail; 
    private int size;
    public Queue(){
        size = 0;
        head = new Node(-1);
        tail = head;  
    }

    /**
     * adds an integer to the queue 
     * @param n
     */
    public void enqueue(int n){
        Node node = new Node(n);
        tail.next = node;
        node.prev = tail;
        tail = tail.next; 
        size++;
    }

    /**
     * returns the node at the front of the QUeue
     */
    public void front(){
        try{
        System.out.println("Front of the queue: " + head.next);
        }
        catch(Exception e){
            System.out.println("Can't get front value for queue size of 0.");
        }
    }
    
    public int dequeue(){
        try{
            int value = head.next.val;
            head.next = head.next.next;
            size--;
            if(size == 0){
                tail = head;
            }
            return value;
        } 
        catch(Exception e){
            System.out.println("Empty Queue. Must have at least one value in the queue");
            return -1;
        }
    }

    /**
    * returns if the queue is empty  
    * @return
    */
    public boolean isEmpty(){
        return size == 0;
    }

    
    private class Node{
        Integer val;
        Node next;
        Node prev;
        private Node(Integer val, Node next){
            this.val = val;
            this.next = next;
        }
        private Node(Integer val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}