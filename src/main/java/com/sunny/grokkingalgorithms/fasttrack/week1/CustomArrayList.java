package com.sunny.grokkingalgorithms.fasttrack.week1;

import java.util.Arrays;

/**
 * Created by sundas on 6/21/2018.
 */
public class CustomArrayList {

  private int capacity = 10;

  private int[] backingArray;

  private int curIndex;

  public CustomArrayList(int size){
    this.capacity = size;
    this.backingArray = new int[this.capacity];
  }

  /**
   *
   * @return
   */
  private int checkCurrentSize(){
    return curIndex;
  }

  /**
   *
   * @param data
   */
  public void add(int data){
    if(checkCurrentSize() == capacity - 1){
      /*
      Resize
       */
      resize();
      //curIndex++;
    }
    backingArray[curIndex++] = data;
  }

  /**
   *
   * @param index
   * @return
   */
  public int remove(int index){
    if(index >= backingArray.length){
      throw new IndexOutOfBoundsException(""+index);
    }
    int data = backingArray[index];
    /*
    Shift data
     */
    shiftLeft(index);
    return data;
  }

  /**
   *
   * @param index
   */
  public void shiftLeft(int index){
    while(index < curIndex){
      backingArray[index] = backingArray[index + 1];
      index++;
    }
    curIndex--;
  }

  private void resize(){
    int[] newArr = new int[2*backingArray.length];
    System.arraycopy(this.backingArray,0,
        newArr,
        0,
        this.backingArray.length);
       this.backingArray = newArr;
       this.capacity = newArr.length;
  }

  @Override
  public String toString() {
    return "CustomArrayList{" +
        "capacity=" + capacity +
        ", backingArray=" + Arrays.toString(backingArray) +
        ", curIndex=" + curIndex +
        '}';
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    CustomArrayList customArrayList = new CustomArrayList(12);
    for(int i =  0 ; i < 10; i++){
      customArrayList.add(i);
    }
    System.out.println(customArrayList);
    System.out.println(customArrayList.remove(4));
    System.out.println(customArrayList);
    System.out.println(customArrayList.remove(0));
    System.out.println(customArrayList);
    System.out.println(customArrayList.remove(2));
    System.out.println(customArrayList);
  }

}
