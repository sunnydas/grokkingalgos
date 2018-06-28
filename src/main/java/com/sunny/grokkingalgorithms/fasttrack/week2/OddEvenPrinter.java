package com.sunny.grokkingalgorithms.fasttrack.week2;

/**
 *
 */
class OddPrinter extends Thread{

  @Override
  public void run() {
    int i = 1;
    while(true){
      try {
        synchronized (this) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(i);
      i += 2;
    }
  }
}

/**
 *
 */
class EvenPrinter extends Thread{

  @Override
  public  void run() {
    int i = 2;
    while(true){
      try {
        synchronized (this) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(i);
      i += 2;
    }
  }
}
/**
 * Created by sundas on 6/28/2018.
 */
public class OddEvenPrinter {


  /**
   *
   * @param args
   */
  public static void main(String[] args) throws InterruptedException {
    Thread oddPrinter = new OddPrinter();
    oddPrinter.start();
    Thread evenPrinter = new EvenPrinter();
    evenPrinter.start();
    int i = 0;
    while(true){
      if(i%2 == 0){
        synchronized (evenPrinter) {
          evenPrinter.notify();
        }
      }
      else{
        synchronized (oddPrinter) {
          oddPrinter.notify();
        }
      }
      Thread.sleep(2000);
      i++;
    }
  }

}