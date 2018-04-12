package com.sunny.grokkingalgorithms.java.threads;

class Printer extends Thread{

  private int val;

  Printer(int val){
    this.val = val;
  }

  public void run(){
    while(true) {
      synchronized (this) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
          break;
        }
        System.out.println(val);
      }
    }
  }


}
/**
 * Created by sundas on 4/12/2018.
 */
public class MultiThreadPrinter {

  /*
  t1 prints 1,1,1....
  t2 prints 2,2,2, ...
  t3 prints 3,3,3....
  o/p: 123123123...
   */

  public static void main(String[] args) {
    Printer[] printers = new Printer[3];
    for(int i = 0 ; i < printers.length ; i++){
      printers[i] = new Printer(i+1);
    }
    for(int i = 0 ; i < printers.length ; i++){
      printers[i].start();
    }
    int i = 0;
    while(true){
      synchronized (printers[i%3]){
        printers[i%3].notify();
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      i++;
    }
  }

}
