public class PalindromeLinkedList {
    private class ListNode {
        private int value;
        private ListNode next;

        ListNode(int data){
            this.value = data;
            this.next = null;
        }
    }

    private ListNode head;

    public ListNode findMiddle(ListNode head){
        ListNode rabit = head;
        ListNode turtle = head;

        while(rabit.next != null && rabit.next.next != null){
            rabit = rabit.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public ListNode reverse(ListNode head){
        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        ListNode firstHalf = head;
        while(secondHalfStart != null){
            if(firstHalf.value != secondHalfStart.value){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    public void printList(ListNode head){
        if(head == null){
            System.out.println("List is empty");
        }
        ListNode current = head;
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){
        PalindromeLinkedList list = new PalindromeLinkedList();
        int[] nums = {1,2,3,1};

        ListNode head = null;
        for(int num : nums){
            ListNode newNode = list.new ListNode(num);
            newNode.next = head;
            head = newNode;
        }

        list.printList(head);
        System.out.println(list.isPalindrome(head));
    }
}