package com.leecode.pratice;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {

        large=new PriorityQueue<Integer>(Comparator.reverseOrder());
        small=new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(large.size()==0&&small.size()==0)large.add(num);
        else if(large.size()>=small.size()){
            if(num>large.peek()){
                small.add(large.poll());
                large.add(num);
            }else{
                small.add(num);
            }
        }else{
            if(num<small.peek()){
                large.add(small.poll());
                small.add(num);
            }else{
                large.add(num);
            }
        }
    }

    public double findMedian() {
        if(large.size()>small.size())return large.peek();
        if(large.size()<small.size())return small.peek();
        return ((double)small.peek()+(double)large.peek())/2;
    }

    @Test
    public void test(){
        MedianFinder f=new MedianFinder();
        f.addNum(1);
        f.addNum(2);
        f.findMedian();// -> 1.5
        f.addNum(3);//
        f.findMedian();// -> 2
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
