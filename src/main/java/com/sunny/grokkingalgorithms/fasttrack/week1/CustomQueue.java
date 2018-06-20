package com.sunny.grokkingalgorithms.fasttrack.week1;

import java.util.Arrays;

/**
 * Created by sundas on 6/20/2018.
 */
public class CustomQueue {

  private int[] backingQueue;

  private int front;

  private int rear;

  private int size;

  private int capacity;

  /**
   *
   * @param capacity
   */
  public CustomQueue(int capacity){
    this.backingQueue = new int[capacity];
    this.capacity = capacity;
  }

  /**
   *
   * @param data
   */
  public  void add(int data){
    if(isFull()){
      return;
    }
    this.backingQueue[this.rear] = data;
    this.rear = (this.rear + 1)%capacity;
    this.size += 1;
  }

  @Override
  public String toString() {
    return "CustomQueue{" +
        "backingQueue=" + Arrays.toString(backingQueue) +
        ", front=" + front +
        ", rear=" + rear +
        ", size=" + size +
        ", capacity=" + capacity +
        '}';
  }

  public int poll(){
    if(isEmpty()){
      return -1;
    }
    int val = this.backingQueue[this.front];
    this.front = (this.front + 1)%capacity;
    this.size -= 1;
    return val;
  }

  /**
   *
   */
  public boolean isFull(){
    return this.size == capacity;
  }

  /**
   *
   * @return
   */
  public boolean isEmpty(){
    return this.size == 0;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    CustomQueue customQueue = new CustomQueue(5);
    customQueue.add(1);
    customQueue.add(2);
    customQueue.add(3);
    customQueue.add(4);
    customQueue.add(5);
    customQueue.add(6);
    System.out.println(customQueue);
    while(!customQueue.isEmpty()){
      System.out.println(customQueue.poll());
    }
    customQueue.add(7);
    customQueue.add(8);
    customQueue.add(9);
    customQueue.add(10);
    customQueue.add(11);
    customQueue.add(6);
    System.out.println(customQueue);
    while(!customQueue.isEmpty()){
      System.out.println(customQueue.poll());
    }
  }
}
