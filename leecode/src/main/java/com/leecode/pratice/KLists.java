package com.leecode.pratice;

import java.util.PriorityQueue;

public class KLists {
    public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            for(ListNode l:lists){
                ListNode curr=l;
                while (curr!=null){
                    queue.offer(curr.val);
                    curr=curr.next;
                }
            }
            ListNode res=new ListNode(queue.poll());
            ListNode curr=res;
            while (!queue.isEmpty()){
                curr.next=new ListNode(queue.poll());
                curr=curr.next;
            }
            return res;
    }
}
