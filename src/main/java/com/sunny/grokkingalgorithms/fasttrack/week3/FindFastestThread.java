package com.sunny.grokkingalgorithms.fasttrack.week3;

import java.lang.management.ManagementFactory;

class myTask implements Runnable{


  @Override
  public void run() {
    long start = System.currentTimeMillis();
    String str = "test";
    for(int i = 0 ; i < 20000 ; i++){
      str += i;
    }
    System.out.println(str);
    long end = System.currentTimeMillis();
    System.out.println(Thread.currentThread().getName() + " " + (end - start) + " Wmillsecs");
  }
}
/**
 * Created by sundas on 7/6/2018.
 */
public class FindFastestThread {

  /*
  Find fastest thread
   */

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Thread t1 = new Thread(new myTask());
    Thread t2 = new Thread(new myTask());
    Thread t3 = new Thread(new myTask());
    /*long time1 = ManagementFactory.getThreadMXBean().getThreadCpuTime(t1.getId());
    long time2 = ManagementFactory.getThreadMXBean().getThreadCpuTime(t2.getId());
    long time3 = ManagementFactory.getThreadMXBean().getThreadCpuTime(t3.getId());
    System.out.println(Math.max(Math.max(time1,time2),time3));*/
    t1.start();
    t2.start();
    t3.start();
  }

}
