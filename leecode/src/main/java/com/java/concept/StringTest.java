package com.java.concept;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class StringTest {

    @Test
    public void trytest() throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024*10);
        ByteBuffer byteBuffer1=ByteBuffer.allocate(1024*10);

        RandomAccessFile file = new RandomAccessFile("file.txt","rw");
        MappedByteBuffer out = file.getChannel().map(FileChannel.MapMode.READ_WRITE,0,10485760);
        String s;
        List a=new LinkedList();
        int[] aa=new int[]{1,2};
        String ss="aaa";
        HashMap map=new HashMap();
//        for(Integer a: map.values())
    }

    @Test
    public void test() {
        String s = "";
        StringBuffer sb;
        ArrayList names = new ArrayList();
        names.add("abcd"); //adding String
        names.add(1);   //adding Integer
        String name = (String) names.get(0); //OK
        name = (String) names.get(1); // throw ClassCastException because you can not convert Integer to String

        byte a = 127;
        byte b = 127;
        //  b = a + b; // error : cannot convert from int to byte
        b += a; // ok
        LinkedHashMap lm = new LinkedHashMap();
//        Stack s=new Stack();
        //       TreeMap
    }
    // }
}
//}
