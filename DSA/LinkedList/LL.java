
public class LL {


    private int size;

    Node head;
    LL() {
        this.size = 0;
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add node at first in the list
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add node at lat in the list
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }

        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    // Delete first node of list
    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
        }

        size--;
        head = head.next;
    }

    // Delete last node of list
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
        }

        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLastNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }

        secondLastNode.next = null;
    }

    // size
    public int getSize(){
        return size;
    }

    // Function to reverse Linked list
    public void reverseIterate(){
        if(head == null){
            return;
        }
        if(head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    // Function to reverse linked list using recursion
    public Node reverseRecursive(Node head){
        if(head.next == null){
            return head;
        }
        if(head == null){
            return head;
        }
        Node currNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return currNode;
    }

    // Print list
    public void printList() {
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    public static void main(String args[]){
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("This");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("This");

        list.printList();
        System.out.println(list.getSize());

        list.reverseIterate();
        list.printList();

        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}
 