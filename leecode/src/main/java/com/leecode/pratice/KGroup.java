package com.leecode.pratice;

import org.testng.annotations.Test;

public class KGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre=null;
        ListNode curr=head;
        int i=0;
        ListNode firstNode=null;
        boolean firstReverse=true;
        while(curr!=null){
            if(i==0)firstNode=curr;
            if(i<k){
                ListNode temp=curr.next;
                curr.next=pre;
                pre=curr;
                curr=temp;
                if(firstReverse)head=pre;
                i++;
            }else{
                firstNode.next=pre;
                pre=curr;
                curr=curr.next;
                i=0;
                firstReverse=false;
            }
        }
        return head;
    }

    @Test
    public void test(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        ListNode r=reverseKGroup(a,2);
        while (r!=null){
            System.out.println(r.val);
            r=r.next;
        }
    }
}
