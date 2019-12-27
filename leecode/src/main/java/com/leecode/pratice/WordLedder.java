package com.leecode.pratice;

import org.junit.Test;

import java.util.*;

public class WordLedder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        begin.add(beginWord);
        end.add(endWord);
        Set<String> dic = new HashSet<String>();
        for(String str : wordList) dic.add(str);

        int length = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            length++;
            if(begin.size() > end.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> tempset = new HashSet<String>();

            for(String bstr: begin){
                char[] bchars = bstr.toCharArray();
                for(int i = 0; i<bstr.length(); i++){
                    char ori = bchars[i];
                    for(char c = 'a' ; c<='z'; c++){
                        bchars[i] = c;
                        String newstr = String.valueOf(bchars);
                        if(end.contains(newstr)){
                            return length;
                        }

                        if(dic.contains(newstr)){
                            dic.remove(newstr);
                            tempset.add(newstr);
                        }

                    }
                    bchars[i] = ori;
                }
            }

            begin = tempset;
        }
        return 0;
    }


    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int i = ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }
}
