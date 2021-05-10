public class LinkedList {
    
    private Node head;
    private int size;
    public LinkedList(){
        head = null; 
        size = 0; 
    }

    /**
     * pushes a new node at the end of the linkedlist
     * @param node
     */
    public void push(Node node){
        if(head == null){
            head = node;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node; 
        size++;
    }

    /**
     * Removes last node at the end of the linked list
     * @return
     */
    public Node pop(){
        
        Node curr = head; 
        Node p2 = null;
        while(curr != null){
            if(curr.next == null){
                p2.next = p2.next.next;
                break;
            } 
            p2 = curr;
            curr = curr.next;   
        }
        size--;
        return curr; 
    }

    /**
     * returns the size of the linked list 
     */
    public int size(){
        return size; 
    }

    /**
     * removes linkedList node at the given index 
     * if there is no node at the location it does nothing
     * 
     * Also will be assuming this is 0 indexed until I receive further clarification 
     * @param index
     */
    public void remove(int index){

        int i = 0;
        Node curr = head; 
        if(index == 0){
            head = head.next;
        }
        else{
            Node p2 = null;
            while(curr != null){
                if(i == index){
                    p2.next = p2.next.next;
                    break;
                }
                p2 = curr; 
                curr = curr.next;
            }
        }
    }

    /**
     * inserts a new node at the given index (0 indexed)
     */
    public void insert(int index, Node node){
        if(index == 0){
            node.next = head;
            head = node;
            return;
        }
        Node curr = head;
        int i = 0;
        Node p2 = null;
        while(curr != null){
            if(i == index){
                node.next = curr;
                p2.next = node;
                break;
            }
            p2 = curr;
            curr = curr.next;
        }
        size++;
    }
    
    /**
     * Returns a pointer to the node at the given index. 
     * @param index
     * @return
     */
    public Node elementAt(int index){
        if(index == 0){
            return head;
        }
        int i = 0;
        Node curr = head;
        while(curr != null){
            if(i == index)
                return curr;
            
            curr = curr.next;
        }
        return curr; 
    }

    /**
     * Returns a string representation of the linked list.
     */
    public void printList(){
        Node curr = head;
        
        while(curr.next != null){
            System.out.print(curr.value + " -> ");
        }
        System.out.print(curr.value);
        System.out.println();
    }


    private class Node{
        int value;
        Node next; 

        public Node (){
        }
        public Node(int value){
            this.value = value;
            this.next = null;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
