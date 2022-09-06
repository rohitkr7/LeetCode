/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        
        for(int i=1; i<=n+1; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        // currently slow is pointing to the just previous element of the desired delete element
        slow.next = slow.next.next;
        
        return start.next;
    }
}