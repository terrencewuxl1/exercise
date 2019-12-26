package com.leecode.pratice.mock;

import java.util.*;

public class MyCircularQueue {


    LinkedList<Integer> link;
    int length;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        link=new LinkedList<>();
        length=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(link.size()==length){
            return false;
        }else {
            link.addFirst(value);
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(link.isEmpty())return false;
        else {
            link.removeLast();
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        return link.getLast();

    }

    /** Get the last item from the queue. */
    public int Rear() {
        return link.getFirst();
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return link.isEmpty();

    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return link.size()==length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
