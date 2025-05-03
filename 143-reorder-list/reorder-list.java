class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revLLHead = reverse(slow.next);
        slow.next = null;

        ListNode forLLHead = head;
        ListNode temp1;
        ListNode temp2;

        while (revLLHead != null) {

            temp1 = forLLHead.next;
            forLLHead.next = revLLHead;
            temp2 = revLLHead.next;
            revLLHead.next = temp1;
            forLLHead = temp1;
            revLLHead = temp2;
        }
    }
}