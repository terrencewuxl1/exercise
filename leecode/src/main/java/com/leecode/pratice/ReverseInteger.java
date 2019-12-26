package com.leecode.pratice;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

    public static int reverse(int x) {
        List<Integer> l = new ArrayList<Integer>();
        int absX = Math.abs(x);
        int tempX = absX;
        while (tempX != 0) {
            int modX = tempX % 10;
            l.add(modX);
            tempX = tempX / 10;
        }
        long revInt = Long.valueOf(0);
        for (int i = 0; i < l.size(); i++) {
            revInt = revInt+ (long) (l.get(i) * Math.pow(10, l.size() - i - 1));
        }
        try{
            return Math.toIntExact(absX - x == 0 ? revInt : 0 - revInt);
        }catch (ArithmeticException e){
            return 0;
        }

    }

    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(reverse(a));
    }
}
