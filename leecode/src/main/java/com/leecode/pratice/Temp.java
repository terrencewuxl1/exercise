package com.leecode.pratice;

import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

public class Temp {

    @Test
    public void temp() {
        Set<String> set = new HashSet<>();
        String s = "12345";
        s.toLowerCase();

        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        map.put(2,map.getOrDefault(2,0)+1);
        int[] a = new int[0];
        PriorityQueue<Integer> q=new PriorityQueue<>();
        String b="123";
        a[0]=Integer.valueOf(null);
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        Queue<Integer> qq=new PriorityQueue<>();
        qq.add(1);
        qq.remove(1);
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        //System.out.println("ss:  "+s.substring(5));
        int[][] aa=new int[5][];
        int[] bb=new int[3];
        Arrays.sort(aa, Comparator.comparingInt(o -> o[2]));
    }

    @Test
    public void test1() {
        int a = Integer.valueOf(null);
        System.out.println(a);
        Map<Integer, Integer> map = new HashMap<>();
        //Arrays.toString()
//        Queue<Integer> small=new LinkedList<>(Comparator.reverseOrder());
        int[] temp=new int[2];

        File



    }
}
