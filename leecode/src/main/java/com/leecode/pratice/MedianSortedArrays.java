package com.leecode.pratice;

public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int temp1;
        int temp2;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                merge[k] = nums2[j];
                j++;
                k++;
            } else if (j == nums2.length) {
                merge[k] = nums1[i];
                i++;
                k++;
            } else {
                if (nums1[i] >= nums2[j]) {
                    merge[k] = nums2[j];
                    j++;
                    k++;
                } else {
                    merge[k] = nums1[i];
                    i++;
                    k++;
                }
            }
        }
        if (merge.length % 2 == 0) {
            Double d1 = Double.valueOf(merge[merge.length / 2 - 1]);
            Double d2 = Double.valueOf(merge[merge.length / 2]);
            return (d1 + d2) / 2;
        } else {
            return merge[merge.length / 2];
        }
    }
}
