package com.sunny.grokkingalgorithms.ctci.c3;

/**
 * Created by sundas on 3/16/2018.
 */
public class ThreesStacksWithOneArray {

  /*
  Implement three stacks with one array
   */

  /*
     Last element will be at head
   */

  private int s1Head;
  private int s1Tail;
  private int s2Tail;
  private int s3Tail;

  private int s2Head;

  private int s3Head;

  public ThreesStacksWithOneArray(int[] stackBackEnd) {
    if(stackBackEnd ==  null || stackBackEnd.length < 3){
      throw new IllegalArgumentException("Invalid input array");
    }
    this.stackBackEnd = stackBackEnd;
    s1Head = 0;
    s1Tail = -1;
    s2Head = stackBackEnd.length/3;
    s2Tail =  s2Head - 1;
    s3Head = 2*(stackBackEnd.length)/3;
    s3Tail = s3Head - 1;
  }

  private int[] stackBackEnd;

  /*
  Divide stack into three portions
  0,n/3 -1 : n/3 -> (2n/3 - 1) : 2n/3 -> n - 1
   */
/*
Head stays one step ahead of tail. Head refers to the next available slot and tail refers to the latest data.
 */

  /**
   *
   * @param data
   */
  public void pushS1(int data){
    if(s1Head < s2Head){
      s1Tail = s1Head;
      stackBackEnd[s1Head++] = data;
    }
    else{
      System.err.println("S1 stack is full");
    }
  }


  /**
   *
   * @param data
   */
  public  void pushS2(int data){
    if(s2Head < s3Head){
      s2Tail = s2Head;
      stackBackEnd[s2Head++] = data;
    }
    else{
      System.err.println("S2 stack is full");
    }
  }


  /**
   *
   * @param data
   * @return
   */
  public void pushS3(int data){
    if(s3Head < stackBackEnd.length){
      s3Tail = s3Head;
      stackBackEnd[s3Head++] = data;
    }
    else{
      System.err.println("S3 stack is full");
    }
  }

  /**
   *
   * @return
   */
  public int popS1(){
    if(s1Tail < 0){
      throw new UnsupportedOperationException("Stack is sempty");
    }
    s1Head--;
    return stackBackEnd[s1Tail--];
  }

  /**
   *
   * @return
   */
  public  int popS2(){
    if(s2Tail < stackBackEnd.length/3){
      throw new UnsupportedOperationException("Stack is sempty");
    }
    s2Head--;
    return stackBackEnd[s2Tail--];
  }

  /**
   *
   * @return
   */
  public int popS3(){
    if(s3Tail < 2*(stackBackEnd.length)/3){
      throw new UnsupportedOperationException("Stack is sempty");
    }
    s3Head--;
    return stackBackEnd[s3Tail--];
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[9];
    ThreesStacksWithOneArray stack = new ThreesStacksWithOneArray(input);
    stack.pushS1(1);
    stack.pushS2(2);
    stack.pushS3(3);
    stack.pushS1(4);
    stack.pushS2(5);
    stack.pushS3(6);
    stack.pushS1(7);
    stack.pushS2(8);
    stack.pushS3(9);
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println("Next .....");
    input = new int[3];
    stack = new ThreesStacksWithOneArray(input);
    stack.pushS1(1);
    stack.pushS2(2);
    stack.pushS3(3);
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println("next ..... ");
    input = new int[10];
    stack = new ThreesStacksWithOneArray(input);
    stack.pushS1(11);
    stack.pushS2(12);
    stack.pushS3(13);
    stack.pushS1(14);
    stack.pushS2(15);
    stack.pushS3(16);
    stack.pushS1(17);
    stack.pushS2(18);
    stack.pushS3(19);
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    System.out.println(stack.popS1());
    System.out.println(stack.popS2());
    System.out.println(stack.popS3());
    try {
      System.out.println(stack.popS3());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    stack.pushS3(20);
    System.out.println(stack.popS3());
    try {
      System.out.println(stack.popS3());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    stack.pushS2(21);
    System.out.println(stack.popS2());
    try {
      System.out.println(stack.popS2());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    stack.pushS1(22);
    System.out.println(stack.popS1());
    try {
      System.out.println(stack.popS1());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    for(int i = 1 ; i < 10 ; i++){
      stack.pushS1(i);
      stack.pushS2(i);
      stack.pushS3(i);
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Popping ... ");
    for(int i = 0; i < 10 ; i++){
      try{
        System.out.println(stack.popS1());
        System.out.println(stack.popS2());
        System.out.println(stack.popS3());
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    }
    System.out.println("next");
    input = new int[8];
    stack = new ThreesStacksWithOneArray(input);
    stack.pushS1(100);
    stack.pushS1(101);
    stack.pushS1(110);
    stack.pushS1(112);
    System.out.println(stack.popS1());
    System.out.println(stack.popS1());
    //System.out.println(stack.popS1());
    //System.out.println(stack.popS1());
    stack.pushS2(110);
    stack.pushS2(112);
    stack.pushS2(125);
    System.out.println(stack.popS2());
    System.out.println(stack.popS2());
    System.out.println(stack.popS2());
    stack.pushS3(121);
    stack.pushS3(123);
    stack.pushS3(124);
    stack.pushS3(125);
    System.out.println(stack.popS3());
    System.out.println(stack.popS3());
    System.out.println(stack.popS3());
  }
}
