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

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode curr1 = leftHead;
        ListNode curr2 = rightHead;
        ListNode newNode = new ListNode(-1);
        ListNode temp = newNode;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                temp.next = curr1;
                curr1 = curr1.next;
            } else {
                temp.next = curr2;
                curr2 = curr2.next;
            }
            temp = temp.next;
        }

        while (curr1 != null) {
            temp.next = curr1;
            curr1 = curr1.next;
            temp = temp.next;
        }

        while (curr2 != null) {
            temp.next = curr2;
            curr2 = curr2.next;
            temp = temp.next;
        }

        return newNode.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftHead = head;

        ListNode sortLeft = sortList(leftHead);
        ListNode sortRight = sortList(rightHead);

        return merge(sortLeft, sortRight);
    }
}