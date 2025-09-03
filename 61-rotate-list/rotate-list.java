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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next == null) return head;

        int sz=1;
        ListNode curr = head;
        while(curr.next != null){
            sz++;
            curr = curr.next;
        }

        k = k % sz;
        if(k==0) return head;
        int pivot = sz-k;
        ListNode temp = head;

        for(int i=1; i<pivot; i++){
            temp = temp.next;
        }
        ListNode newHead = temp.next;

        curr.next = head;
        temp.next = null;
        return newHead;
    }
}