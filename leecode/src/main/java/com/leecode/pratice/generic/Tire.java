package com.leecode.pratice.generic;

public class Tire implements Comparable<Tire> {

    int size;

    public Tire(int s) {
        size = s;
    }

    @Override
    public int compareTo(Tire o) {
        if (size < o.size) return -1;
        else if (size > o.size) return 1;
        return 0;
    }
}
