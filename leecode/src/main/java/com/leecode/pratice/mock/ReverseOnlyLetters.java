package com.leecode.pratice.mock;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {

        char[] arr = S.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(!Character.isLetter(arr[i]))i++;
            if(!Character.isLetter(arr[j]))j--;
            if(Character.isLetter(arr[i])&&Character.isLetter(arr[j])){
                char temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }
}
