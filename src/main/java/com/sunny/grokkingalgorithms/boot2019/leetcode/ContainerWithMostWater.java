package com.sunny.grokkingalgorithms.boot2019.leetcode;

public class ContainerWithMostWater {

    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
     */

    public static int maxArea(int[] height){
        int maxArea = 0;
        for(int i = 0 ; i < height.length; i++){
            int curHeight = height[i];
            int lIndex = i - 1;
            int rIndex = i + 1;
            while(lIndex >= 0 || rIndex < height.length){
                int curLength = 0;
                if(lIndex >= 0) {
                    curLength += i - lIndex;
                }
                if(rIndex < height.length){
                    curLength += rIndex - i;
                }
                if(curLength >= 1){
                    int rArea = Integer.MIN_VALUE;
                    int lArea = Integer.MIN_VALUE;
                    if(lIndex >= 0 && height[lIndex] >= curHeight){
                        lArea = curHeight*(i - lIndex);
                    }
                    if(rIndex < height.length && height[rIndex] >= curHeight){
                        rArea = curHeight*(rIndex - i);
                    }
                    int totalArea = 0;
                    if(lArea > 0){
                        totalArea += lArea;
                    }
                    if(rArea > 0){
                        totalArea += rArea;
                    }
                    if(totalArea > 0 && totalArea > maxArea){
                        maxArea = totalArea;
                    }
                }
                if(lIndex >= 0) {
                    lIndex--;
                }
                if(rIndex < height.length) {
                    rIndex++;
                }
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
        input = new int[]{1,1};
        System.out.println(maxArea(input));
    }

}
