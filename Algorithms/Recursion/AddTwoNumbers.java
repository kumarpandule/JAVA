
public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    ListNode head;

    public void printList(ListNode head){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode arrayToList(int[] arr){
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i=0; i<arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode current = null;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int total = l1Val + l2Val + carry;
            ListNode newNode = new ListNode(total % 10);
            carry = total / 10;

            if(head == null){
                head = newNode;
                current = newNode;
            }else{
                current.next = newNode;
                current = current.next;
            }

            if(l1 != null){
                l1 = l1.next;
            }
    
            if(l2 != null){
                l2 = l2.next;
            }
        }
       return head;
    }

    public static void main(String args[]){
        AddTwoNumbers list = new AddTwoNumbers();
        int[] l1Array = {2,4,3};
        int[] l2Array = {5,6,4};

        ListNode l1 = list.arrayToList(l1Array);
        ListNode l2 = list.arrayToList(l2Array);

        list.printList(l1);
        list.printList(l2);

        list.printList(list.addTwoNumbers(l1, l2));
    }
}