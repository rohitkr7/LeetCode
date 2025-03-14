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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Insert all the head nodes of the given list items to the minHeap
        for (ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }

        // Until the minHeap becomes empty
        // Pop the root (Extract the minimum element) and point current pointer to the
        // node, if the extracted element has next pointer not null element then
        // add that element to the minHeap

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;

    }
}