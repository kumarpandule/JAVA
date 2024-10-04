public class QueueUsingLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    static class Queue {
        static ListNode head = null;
        static ListNode rear = null;

        public static boolean isEmpty(){
            return head == null && rear == null;
        }

        public static void add(int val){
            ListNode newNode = new ListNode(val);
            if(isEmpty()){
                head = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return head.val;
        }

        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            if(head == rear){
                rear = null;
            }

            int front = head.val;
            head = head.next;
            return front;
        }
    }
    
    public static void main(String args[]){
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek() + " ");
            q.remove();
        }
    }
}
