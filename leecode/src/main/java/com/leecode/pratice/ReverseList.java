package com.leecode.pratice;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nextTemp;
        }
        return pre;

    }


}
