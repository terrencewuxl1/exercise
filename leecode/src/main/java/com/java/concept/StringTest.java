package com.java.concept;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StringTest {

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
        LinkedHashMap lm= new LinkedHashMap();
//        Stack s=new Stack();
 //       TreeMap
    }
        // }
    }
//}
