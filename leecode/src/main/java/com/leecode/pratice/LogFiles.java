package com.leecode.pratice;

import java.util.Arrays;

public class LogFiles {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (o1, o2) -> {
            String identify1=o1.substring(0,o1.indexOf(" "));
            String identify2=o2.substring(0,o2.indexOf(" "));
            o1=o1.substring(o1.indexOf(" ")+1);
            o2=o2.substring(o1.indexOf(" ")+1);
            if(Character.isLetter(o1.charAt(0))&&Character.isDigit(o2.charAt(0)))
                return 1;
            if(Character.isLetter(o2.charAt(0))&&Character.isDigit(o1.charAt(0)))
                return -1;
            if(Character.isLetter(o1.charAt(0))&&Character.isLetter(o2.charAt(0))){
                for(int i=0;i<o1.length();i++){
                    int temp=Character.compare(o1.charAt(i),o2.charAt(i));
                    if(temp!=0)return temp;
                }
                for(int i=0;i<identify1.length();i++){
                    int temp=Character.compare(identify1.charAt(i),identify2.charAt(i));
                    if(temp!=0)return temp;
                }
            }
            return 0;
        });

        return logs;
    }
}
