package linkedlist;

/*
    Q. Reverse the Linked List
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head, pre = null;

        while (curr != null) {
            ListNode post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }

        return pre;
    }
}
