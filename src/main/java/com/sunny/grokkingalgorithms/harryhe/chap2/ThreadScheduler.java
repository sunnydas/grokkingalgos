package com.sunny.grokkingalgorithms.harryhe.chap2;

/**
 * Created by sundas on 3/4/2017.
 */
class Printer{

  private int counter;

  public Printer(){
    this.counter = 1;
  }

  public synchronized void printT1() throws InterruptedException {
    while(counter != 1){
      wait();
    }
    System.out.println(Thread.currentThread().getName() + " " + 1);
    counter++;
    notifyAll();
  }

  public synchronized void printT2() throws InterruptedException {
    while(counter != 2){
      wait();
    }
    System.out.println(Thread.currentThread().getName() + " " + 2);
    counter++;
    notifyAll();
  }

  public synchronized void printT3() throws InterruptedException {
    while(counter != 3){
      wait();
    }
    System.out.println(Thread.currentThread().getName() + " " + 3);
    counter = 1;
    notifyAll();
  }

}
class Worker implements Runnable{

  private Printer printer;

  private int threadId;

  public Worker(Printer printer,int threadId){
    this.printer = printer;
    this.threadId = threadId;
  }

  public void run(){
    //int i = 0;
    while(true) {
      try {
        if (threadId == 1) {
          printer.printT1();
        } else if (threadId == 2) {
          printer.printT2();
        } else if (threadId == 3) {
          printer.printT3();
        } else {
          throw new AssertionError("invalid thread id = " + this.threadId);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //i++;
    }
  }
}
public class ThreadScheduler {

  /*
  One thread prints 111
  second thread prints 222
   third thread prints 333
   How do we print 123123123
   */

  /**
   *
   * @param args
   */
  public static void main(String[] args) throws InterruptedException{
    Printer printer = new Printer();
    Worker worker1 = new Worker(printer,1);
    Worker worker2 = new Worker(printer,2);
    Worker worker3 = new Worker(printer,3);
    Thread t1 = new Thread(worker1,"t1");
    Thread t2 = new Thread(worker2,"t2");
    Thread t3 = new Thread(worker3,"t3");
    t3.start();
    Thread.sleep(1000);
    t1.start();
    Thread.sleep(1000);
    t2.start();
    Thread.sleep(1000);
  }

}