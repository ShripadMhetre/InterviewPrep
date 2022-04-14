package linkedlist;

import static linkedlist.PrintLinkedList.printList;
import static linkedlist.ReverseList.reverseList;


/*
    Q. Given a linked list of the form:
        N0 → N1 → N2 → ....Nn-2 → Nn-1

       Reorder the list in the following format:
        N0 → Nn-1 → N1 → Nn-2 → N2 → ....

        Example:-
            Linked list: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9
            Result: 1 → 9 → 2 → 8 → 3 → 7 → 4 → 6 → 5

            Linked list: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
            Result: 1 → 8 → 2 → 7 → 3 → 6 → 4 → 5
 */
public class ReorderList {
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Get the middle node using two pointer approach
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // divide the list into two lists
        ListNode second = slow.next;
        slow.next = null;

        // reverse the second list
        second = reverseList(second);

        // Merge the two lists by adding nodes alternatively
        ListNode temp1 = head, temp2 = second;
        while (temp1 != null && temp2 != null) {
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;

            temp1 = next1;
            temp2 = next2;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        ListNode eighth = new ListNode(8);

        head.next = second;
        second.next = third;
        third.next  = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = null;

        printList(head);
    }
}
