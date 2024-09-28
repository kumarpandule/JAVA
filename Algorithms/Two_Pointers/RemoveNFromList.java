public class RemoveNFromList {
    private ListNode head;

    // ListNode class definition
    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        if (n == size) {
            return head.next;
        }

        current = head;
        for (int i = 1; i < size - n; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int n = 2;
        RemoveNFromList list = new RemoveNFromList();

        int[] nums = {1, 2, 3, 4, 5};
        list.addFirst(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            list.addLast(nums[i]);
        }

        list.head = list.removeNthFromEnd(list.head, n);
        list.printList();
    }
}