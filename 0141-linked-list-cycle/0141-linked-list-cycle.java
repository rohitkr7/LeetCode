/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<ListNode>();
        ListNode node = head;
        while(node!=null){
            if(hs.contains(node))
                return true;
            hs.add(node);
            node = node.next;
        }
        return false;
    }
}