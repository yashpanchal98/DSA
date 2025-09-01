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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddHead = new ListNode(-1);
        ListNode temp1 = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode temp2 = evenHead;

        ListNode curr = head;
        boolean odd = true;

        while(curr != null){

            if(odd){
                temp1.next = curr;
                temp1 = temp1.next;
                odd = false;
            } else {
                temp2.next = curr;
                temp2 = temp2.next;
                odd = true;
            }
            curr = curr.next;
        }
        temp1.next = evenHead.next;
        temp2.next = null;
        return oddHead.next;
    }
}