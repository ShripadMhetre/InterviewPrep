package linkedlist;

/*
    Q. Print the LinkedList.
 */
public class PrintLinkedList {
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
