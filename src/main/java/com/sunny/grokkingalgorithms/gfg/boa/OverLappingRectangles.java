package com.sunny.grokkingalgorithms.gfg.boa;

/**
 * Created by sundas on 4/5/2018.
 */
class Point{
  int x;
  int y;
}
public class OverLappingRectangles {

  /*
  Total area of two overlapping rectangles
Given two overlapping rectangles on a plane. We are given bottom left and top right points of the two rectangles.
We need to find the total area (Green and pink areas in below diagram).

https://www.geeksforgeeks.org/total-area-two-overlapping-rectangles/


Input : Point l1 = {2, 2}, r1 = {5, 7};
        Point l2 = {3, 4}, r2 = {6, 9};
Output : Total Area = 24

Input :Point l1 = {2, 1}, r1 = {5, 5};
       Point l2 = {3, 2}, r2 = {5, 7};
Output : Total Area = 16
   */

  /**
   *
   * @param l1
   * @param r1
   * @param l2
   * @param r2
   * @return
   */
  public static int findTotalAreaOfOveralappingRecatangles(Point l1,Point r1,Point l2,Point r2){
    int area = 0;
    /*
    Find overlap area
     */
    int areaRect1 = Math.abs(r1.x - l1.x)*Math.abs(r1.y - l1.y);
    int areaRect2 = Math.abs(r2.x - l2.x)*Math.abs(r2.y - l2.y);
    int intersectArea = (Math.max(l1.x,l2.x) - Math.min(r1.x,r2.x))*(Math.max(l1.y,l2.y) - Math.min(r1.y,r2.y));
    area = areaRect1 + areaRect2 - intersectArea;
    return area;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Point l1 = new Point();
    l1.x = 2;
    l1.y = 2;
    Point r1 = new Point();
    r1.x = 5;
    r1.y = 7;
    Point l2 = new Point();
    l2.x = 3;
    l2.y = 4;
    Point r2 = new Point();
    r2.x = 6;
    r2.y = 9;
    System.out.println(findTotalAreaOfOveralappingRecatangles(l1, r1, l2, r2));
  }

}
