package com.sunny.grokkingalgorithms.fasttrack;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Created by sundas on 6/17/2018.
 */
class Point3D extends Point2D{
  int z;


  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  double dist3D(Point3D p){
    double x2minusx1 = p.x - this.x ; //x2 - x1
    double y2minusy1 = p.y - this.y; //y2 - y1
    double z2minusz1 = p.z - this.z;
    return Math.sqrt(Math.pow(x2minusx1,2) + Math.pow(y2minusy1,2)
    + Math.pow(z2minusz1,2));
  }

  void printDistance(double d){
    super.printDistance2D(d);
  }
}
public class Point2D {

   int x;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

   int y;

  double dist2d(Point2D p){
    double x2minusx1 = p.x - this.x ; //x2 - x1
    double y2minusy1 = p.y - this.y; //y2 - y1
    return Math.sqrt(Math.pow(x2minusx1,2) - Math.pow(y2minusy1,2));
  }

  void printDistance2D(double d){
    System.out.println(Math.ceil(d));
  }

  public static void main(String[] args) {
    NumberFormat fmt = NumberFormat.getNumberInstance();
    fmt.setMaximumFractionDigits(0);
    fmt.setRoundingMode(RoundingMode.CEILING);
    String val = fmt.format(4.44);
    System.out.println(val);
  }

}
