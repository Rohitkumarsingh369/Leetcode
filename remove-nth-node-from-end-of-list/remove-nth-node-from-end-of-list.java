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
	    if(n <= 0) return head;
    	ListNode b = head;
	    for(int i=1;i<n && b!=null;i++) {
	        b = b.next;
        }
        if(b == null) return head.next;
        ListNode a = head;
        ListNode prevNode = null;
        while(b.next != null){
	        prevNode = a;
	        a = a.next;
            b = b.next;
        }
        if(a == head) return head.next;
        else {
	        prevNode.next = a.next;
	        return head;
        }
    }
}

