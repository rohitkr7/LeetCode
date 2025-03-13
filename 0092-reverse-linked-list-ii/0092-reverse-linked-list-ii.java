/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev, current;
        leftPrev = dummy;
        current = head;

        // Step 1: Reach to the left node
        for (int i = 0; i < left - 1; i++) {
            leftPrev = current;
            current = current.next;
        }
        // At this point leftPrev stands just behind the given left index
        // current points to the actual left index node

        // Step 2: Reverse the nodes
        ListNode tempNext = null, prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }

        leftPrev.next.next = current;
        leftPrev.next = prev;
        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}