class Solution {

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode RH, ListNode LH){

        ListNode curr1 = RH;
        ListNode curr2 = LH;
        ListNode newNode = new ListNode();
        ListNode temp = newNode;

        while(curr1!=null && curr2!=null){
            if(curr1.val>=curr2.val){
                temp.next = curr2;
                curr2 = curr2.next;
            } else {
                temp.next = curr1;
                curr1 = curr1.next;
            }
            temp = temp.next; 
        }

        while(curr1!=null){
            temp.next = curr1;
            curr1 = curr1.next;
            temp = temp.next;
        }
         while(curr2!=null){
            temp.next = curr2;
            curr2 = curr2.next;
            temp = temp.next;
        }

        return newNode.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;

        ListNode mid = findMid(head);
        ListNode rightH = mid.next;
        mid.next = null;
        ListNode leftH = head;


        ListNode RH = sortList(rightH); 
        ListNode LH = sortList(leftH);  

        return merge(RH, LH);
    }
}
