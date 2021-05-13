


import java.util.*;
public class App {

    
public static LinkedList reverseLinkedListIteratively(LinkedList head){
    if(head.head == null){
        return null;
    }
    Node curr = head.head;
    Node prev = null;
    while(curr != null){
        Node p3 = curr.next;
        curr.next = prev;
        prev = curr;
        curr = p3; 
    }

    head.head = prev;
    return  head; 
}

public static LinkedList reverseLinkedListStack(LinkedList head){
    
    if(head.head == null){
        return null;
    }
    Stack<Node> stack = new Stack <>();
    Node curr = head.head;
    while(curr != null){
        stack.push(curr);
        curr = curr.next;
    }
    
    Node head2 = new Node(-1);
    Node curr2 = head2;  
    while(!stack.isEmpty()){
        Node node = new Node(stack.pop().value);
        curr2.next = node;
        curr2 = curr2.next;
    }
    head.head = head2.next; 
    return head;
}

/*
public static LinkedList reverseLinkedListRecursively(LinkedList head){
    
    Node curr = reverseNodes(head.head, null);
    
    return head; 
}
public static Node reverseNodes(Node curr, Node prev){
    if(curr == null){
        return null; 
    }

    curr.next = reverseNodes(curr.next, curr);
    
    return curr; 
}
*/ 
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        Node node = new Node(12);
        list.push(node);
        for(int i = 0; i < 10; i++){
            int num = i;
            list.push(new Node(i));
        }
        list.printList();
        reverseLinkedListIteratively(list);
        list.printList();
        reverseLinkedListStack(list);
        list.printList();
        reverseLinkedListRecursively(list);
        list.printList();
    }
}
