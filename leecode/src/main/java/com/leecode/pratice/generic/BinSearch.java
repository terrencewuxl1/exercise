package com.leecode.pratice.generic;

import java.util.Arrays;

public class BinSearch{

    public static <T extends Comparable<T>> int search(T[] table, int start, int finish, T searchKey) {
        if (start > finish) return -1;

        int mid = (start + finish) / 2;
        if (table[mid].compareTo(searchKey) > 0)
            return search(table, start, mid - 1, searchKey);
        else if (table[mid].compareTo(searchKey) < 0)
            return search(table, mid + 1, finish, searchKey);
        else return mid;
    }

    public static <T extends Comparable<T>> int search(T[] table, T searchKey){
        return search(table,0,table.length-1,searchKey);
    }

    public static void main(String[] args){
        Integer[] arr1=new Integer[]{12,32,143,3,432,565,66,78,97};
        Arrays.sort(arr1);
        System.out.println(BinSearch.search(arr1,99));
        Character[] arr2=new Character[]{'a','f','r','g','l','d'};
        Arrays.sort(arr2);
        System.out.println(BinSearch.search(arr2,'g'));
        Tire compactTire=new Tire(15);
        Tire suvTire=new Tire(17);
        Tire truckTire = new Tire(23);
        Tire[] arr3=new Tire[]{compactTire,suvTire,truckTire};
        System.out.println(BinSearch.search(arr3,truckTire));
    }
}
