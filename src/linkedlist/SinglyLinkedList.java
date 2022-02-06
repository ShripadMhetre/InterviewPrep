package linkedlist;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
        next = null;
    }
}

/**
 * Singly Linked List:-
 *      1. Reverse Linked List -> reverseLL(Node head)
 *      2. Detect Cycle in LL -> detectCycle(Node head)
 *      3. Find middle of LL -> findMiddle(Node head)
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printLL(head);
//        Node newHead = reverseLL(head);
//        printLL(newHead);

        System.out.println("Is Cycle Present: " + detectCycle(head));

        Node middle = findMiddle(head);
        System.out.println("Middle Node of LL is: " + middle.value);
    }

    private static Node findMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static boolean detectCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    private static Node reverseLL(Node head) {
        // Base Case
        if (head == null || head.next == null) return head;

        Node curr = head, prev = null, next = head.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        // reversing last Node's next pointer
        curr.next = prev;

        // Return the new head of reversed LL
        return curr;
    }

    private static void printLL(Node head) {
        if (head == null) return;

        Node temp = head;

        while(temp.next != null) {
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }


}
