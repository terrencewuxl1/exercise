package com.java.concept;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Testcase {

    @Test
    public void test() {

        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.addFirst(4);
        list.addLast(5);
        System.out.println(list.toString());

    }
}
