package com.sunny.grokkingalgorithms.chap4;

import java.util.Scanner;
class IdealPlot{
  private int length;

  @Override
  public String toString() {
    return "IdealPlot{" +
        "length=" + length +
        ", breath=" + breath +
        '}';
  }

  public int getBreath() {
    return breath;
  }

  public void setBreath(int breath) {
    this.breath = breath;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  private int breath;
}
/**
 * Created by sundas on 1/5/2017.
 */
public class PlotDivision {

  /**
   *
   * @param length
   * @param breath
   * @return
   */
  public static int calculateIdealPlot(int length,int breath){
    int area = -1;
    if((length > breath && length % breath == 0) || (breath > length && breath % length == 0)){
      if(length <= breath){
        System.out.println(" side = " + length);
        area =   length * length;
      }
      else{
        System.out.println(" side = " + breath);
       area =  breath*breath;
      }
    }
    else if(length > breath){
      int remainder = length % breath;
      area =  calculateIdealPlot(remainder,breath);
    }
    else if(breath > length){
      int remainder = breath % length;
      area =  calculateIdealPlot(length,remainder);
    }
    return area;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int length = scanner.nextInt();
    int breath = scanner.nextInt();
    System.out.println("Ideal area = " + calculateIdealPlot(length,breath));
  }
}
