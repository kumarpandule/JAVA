public class MergeSortedTwoList {

    private  class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode fillList(int[] l){
        if(l == null || l.length == 0){
            return null;
        }

        ListNode list1 = new ListNode(l[0]);
        ListNode current = list1;

        for(int i=1; i<l.length; i++){
            ListNode newNode = new ListNode(l[i]);
            current.next = newNode;
            current = newNode;
        }

        return list1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // Base cases
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // Recursive case
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public void printList(ListNode list){
         if(list == null){
            System.out.println("List is empty");
            return;
         }

         ListNode head = list;
         while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
         }
         System.out.print("null");
    }

    public static void main(String args[]){
        MergeSortedTwoList list = new MergeSortedTwoList();
        
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};

        ListNode list1 = list.fillList(l1);
        ListNode list2 = list.fillList(l2);

        list.printList(list1);
        System.out.println();
        list.printList(list2);

        System.out.println();
        list.printList(list.mergeTwoLists(list1, list2));
    }
}
