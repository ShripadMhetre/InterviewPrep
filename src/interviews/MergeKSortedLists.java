package interviews;

import linkedlist.ListNode;

public class MergeKSortedLists {
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return result.next;
    }

    public static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start)/2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid+1, end);
        return merge(left, right);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(7);
        l3.next.next = new ListNode(8);

        ListNode[] lists = {l1, l2, l3};

        ListNode head = mergeKLists(lists, 0, lists.length-1);

        printList(head);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
