package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Result{

  private List<Integer> zerosToBeFlipped;

  private int sum;

  public List<Integer> getZerosToBeFlipped() {
    return zerosToBeFlipped;
  }

  public void setZerosToBeFlipped(List<Integer> zerosToBeFlipped) {
    this.zerosToBeFlipped = zerosToBeFlipped;
  }

  @Override
  public String toString() {
    return "Result{" +
        "zerosToBeFlipped=" + zerosToBeFlipped +
        ", sum=" + sum +
        '}';
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }
}
/**
 * Created by sundas on 3/23/2017.
 */
public class FindZerosToBeFlipped {

  //http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/

  //https://www.careercup.com/question?id=5106425965576192

  /**
   *
   * @param input
   * @param m
   * @return
   */
  public static List<Integer> slidingWindowSolution(int[] input,int m){
    List<Integer> zerosToBeFilledTemp = null;
    List<Integer> zerosToBeFilled = null;
    int windowLeft = 0;
    int windowRight = 0;
    int currentZeroCount = 0;
    int currentSize = 0;
    int maxSize = 0;
    while(windowLeft < input.length && windowRight < input.length){
      int current = input[windowRight];
      if((current == 0 && currentZeroCount < m) || (current == 1)){
        if(current == 0) {
          currentZeroCount++;
          if (zerosToBeFilledTemp == null) {
            zerosToBeFilledTemp = new ArrayList<>();
          }
          zerosToBeFilledTemp.add(windowRight);
        }
        if(windowRight
            == input.length - 1){
          currentSize = windowRight - windowLeft;
          if(currentSize > maxSize){
            maxSize = currentSize;
            zerosToBeFilled = zerosToBeFilledTemp;
          }
        }
        windowRight++;
      }
      else if(current == 0
          && currentZeroCount >= m){
        currentSize = windowRight - windowLeft;
        if(currentSize > maxSize){
          maxSize = currentSize;
          zerosToBeFilled = zerosToBeFilledTemp;
        }
        if(input[windowLeft] == 0){
          currentZeroCount--;
          zerosToBeFilledTemp.remove(0);
        }
        windowLeft++;
        //zerosToBeFilledTemp = null;
      }
    }
    return zerosToBeFilled;
  }

  /**
   *
   * @param input
   * @return
   */
  public static List<Integer> findNoOfZerosToBeFlipped(int[] input,int m){
    List<Integer> zerosTobeFilled = null;
    int maxSoFar = Integer.MIN_VALUE;
    for(int i = 0 ; i < input.length ; i++){
      Result result = findMaxSubArrayResult(input, i, m);
      if(result.getSum() > maxSoFar){
        maxSoFar = result.getSum();
        zerosTobeFilled = result.getZerosToBeFlipped();
      }
    }
    return zerosTobeFilled;
  }

  /**
   *
   * @param input
   * @param index
   * @param m
   * @return
   */
  public static Result findMaxSubArrayResult(int[] input,int index,int m){
    Result result = null;
    int zeroCount =  0;
    int sumSoFar = 0;
    for(int i = index ; i < input.length ; i++){
      if(input[i] == 0){
        if(zeroCount >= m){
          break;
        }
        if(result == null){
          result = new Result();
          List<Integer> zeroIndexes = new ArrayList<>();
          zeroIndexes.add(i);
          result.setZerosToBeFlipped(zeroIndexes);
          result.setSum(result.getSum()+1);
          sumSoFar++;
          zeroCount++;
        }
        else{
          result.setSum(result.getSum()+1);
          if(result.getZerosToBeFlipped() == null){
            List<Integer> integers = new ArrayList<>();
            result.setZerosToBeFlipped(integers);
          }
          result.getZerosToBeFlipped().add(i);
          sumSoFar++;
          zeroCount++;
        }
      }
      else if(input[i] == 1){
        sumSoFar++;
        if(result == null) {
          result = new Result();
        }
        result.setSum(sumSoFar);
      }
    }
   return result;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
   /* 11
    2
    1
    0
    0
    1
    1
    0
    1
    0
    1
    1
    1*/
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] input = new int[n];
    for(int i = 0 ; i < input.length ; i++){
      input[i] = scanner.nextInt();
    }
    System.out.println(findNoOfZerosToBeFlipped(input,m));
    System.out.println(slidingWindowSolution(input,m));
  }

}
