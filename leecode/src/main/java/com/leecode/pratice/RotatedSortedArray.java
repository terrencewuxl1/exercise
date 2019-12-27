package com.leecode.pratice;


import org.junit.Test;

public class RotatedSortedArray {

    public int getIndexInSorted(int[] arr, int target,int i,int j){
        int index=i;
        while (i<j){
            int mid=(i+j)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target)j=mid-1;
            else if(arr[mid]<target)i=mid+1;
        }
        if(target==arr[i])return i;
        else return -1;
    }

    public int findMinimum(int[] arr){
        int i=0;
        int j=arr.length-1;
        int index=0;
        while (i<j){
            int mid=(i+j)/2;
            if(arr[i]<=arr[mid])i=mid+1;
            else  j=mid-1;
        }
        return i+1;
    }

    public int getIndexInRotated(int[] arr,int target){
        int minIndex=findMinimum(arr);
        if(target>=arr[0])return getIndexInSorted(arr,target,0,minIndex-1);
        else return getIndexInSorted(arr,target,minIndex,arr.length-1);
    }

    @Test
    public void test(){
        int[] arr=new int[]{3,4,5,5,5,7,8,9,0,1,1,2};
        System.out.println(getIndexInRotated(arr,5));
        System.out.println(getIndexInRotated(arr,7));
        System.out.println(getIndexInRotated(arr,0));
        System.out.println(getIndexInRotated(arr,1));
        System.out.println(getIndexInRotated(arr,10));
        System.out.println(getIndexInRotated(arr,9));
    }
}
