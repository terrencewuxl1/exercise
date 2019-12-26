package com.leecode.pratice;

public class TrapTrainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftmax) {
                    ans += leftmax - height[left];
                } else {
                    leftmax = height[left];
                }
                ++left;
            } else {
                if (height[right] < rightmax) {
                    ans += rightmax - height[right];
                } else {
                    rightmax = height[right];
                }
                --right;
            }
        }
        return ans;
    }
}
