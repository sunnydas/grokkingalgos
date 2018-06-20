package com.sunny.grokkingalgorithms.fasttrack.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sundas on 6/20/2018.
 */
public class CustomBlockingQueue {

  /*
  Create your own blocking queue
   */

  private int[] queue;

  private int head;

  private int tail;

  /**
   *
   * @param size
   */
  public CustomBlockingQueue(int size){
    this.queue = new int[size];
  }


  /**
   *
   * @param a
   */
  public void add(int a){
    synchronized (this.queue){
      while(tail >= queue.length){
        try {
          this.queue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      this.queue[tail] = a;
      tail++;
      this.queue.notify();
    }
  }

  /**
   *
   * @return
   */
  public boolean isEmpty(){
    return head == 0
        && tail == 0;
  }

  @Override
  public String toString() {
    return "CustomBlockingQueue{" +
        "queue=" + Arrays.toString(queue) +
        ", head=" + head +
        ", tail=" + tail +
        '}';
  }

  /**
   *
   * @return
   */
  public int poll(){
    int val = -1;
    synchronized (this.queue){
      while(head == 0
          && tail == 0){
        try {
          this.queue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      val = this.queue[head];
      if(head < this.queue.length) {
        head++;
      }
      if(head >= this.queue.length){
        head = 0;
        tail = 0;
      }
      this.queue.notify();
    }
    return val;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    CustomBlockingQueue queue = new CustomBlockingQueue(5);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    //queue.add(6);
    //queue.add(7);
    System.out.println(queue);
    while(!queue.isEmpty()){
      System.out.println(queue.poll());
    }
    //queue.poll();
    System.out.println(queue);
    queue.add(5);
    queue.add(6);
    queue.add(7);
    queue.add(8);
    queue.add(9);
    System.out.println(queue);
    while(!queue.isEmpty()){
      System.out.println(queue.poll());
    }
  }

}
