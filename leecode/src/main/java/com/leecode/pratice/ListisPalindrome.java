package com.leecode.pratice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListisPalindrome {



    public boolean listisPalidrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)-list.get(list.size()-1-i)!=0)
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        ListNode head=new ListNode(-129);
        head.next=new ListNode(-129);
        System.out.println(listisPalidrome(head));
    }
}
