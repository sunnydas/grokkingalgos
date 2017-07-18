package com.sunny.grokkingalgorithms.java.concurrency.locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
class ProtectedResource{

  public ProtectedResource(MyReentrantLock lock) {
    this.lock = lock;
  }

  private MyReentrantLock lock;


  public void doSomething(){

    lock.lock();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(" Data availabale " + Thread.currentThread().getName());
    lock.unlock();

  }




}
/**
 * Created by sundas on 7/18/2017.
 */
public class MyReentrantLock {

  /*
  Implement reentrant lock of your own
   */

  private volatile  AtomicInteger lockVar = new AtomicInteger(0);

  private  volatile AtomicReference<Thread> currentOwner = new AtomicReference<>();


  /**
   *
   */
  public void lock(){
    // not owner or lock can be acuired
    while(!isOwningThread() && !isLockAquirable()){
      synchronized (this){
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
          return;
        }
      }
    }
    lockVar.incrementAndGet();
  }



  /**
   *
   * @return
   */
  public boolean isLockAquirable(){
    return this.currentOwner.compareAndSet(null,Thread.currentThread());
  }

  /**
   *
   * @return
   */
  public boolean isOwningThread(){
    return this.currentOwner.compareAndSet(Thread.currentThread(),Thread.currentThread());
  }


  /**
   *
   */
  public void unlock(){
    if(isOwningThread()){
      lockVar.decrementAndGet();
      if(lockVar.get() == 0){
        currentOwner.compareAndSet(Thread.currentThread(),null);
        try {
          //not happy with this
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }

      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    MyReentrantLock lock = new MyReentrantLock();
    ProtectedResource protectedResource = new ProtectedResource(lock);
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        protectedResource.doSomething();
      }
    };
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    thread1.start();
    thread2.start();
  }
}
