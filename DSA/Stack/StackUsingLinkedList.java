public class StackUsingLinkedList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    static class Stack {
        public static ListNode head;

        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int val){
            ListNode newNode = new ListNode(val);
            if(isEmpty()){
                head =  newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
    }
    public static void main(String args[]){
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while(!Stack.isEmpty()){
            System.out.print(Stack.peek() + " ");
            Stack.pop();
        }

    }
}
