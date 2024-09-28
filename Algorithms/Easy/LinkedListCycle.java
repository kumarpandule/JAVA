


public class LinkedListCycle {
    private class ListNode{
        private int val;
        private ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    ListNode head;

    public void removeCycle(ListNode meet){
        // If no cycle is detected, return
        if (meet == null) {
            return;
        }

        // Find the start of the cycle
        ListNode start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }

        // Find the last node in the cycle
        ListNode last = start;
        while (last.next != start) {
            last = last.next;
        }

        // Remove the cycle
        last.next = null;
    }

    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode hare = head;
        ListNode turtle = head;
        ListNode meet = null;

        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                meet = hare;
                return true;
            }
        }
        removeCycle(meet);
        return false;
    }

    public static void main(String args[]){
        LinkedListCycle list = new LinkedListCycle();

        // Create nodes
        ListNode node1 = list.new ListNode(3);
        ListNode node2 = list.new ListNode(2);
        ListNode node3 = list.new ListNode(0);
        ListNode node4 = list.new ListNode(-4);

        // Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create cycle here

        // Set head
        list.head = node1;

        // Now you can test the hasCycle method
        System.out.println(list.hasCycle(list.head)); // Should return true if cycle detection is implemented
    }
}
