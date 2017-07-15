package com.sunny.grokkingalgorithms.java.concurrency;

import java.util.concurrent.*;

/**
 * Created by sundas on 7/15/2017.
 */
public class ExecutorFrameworkTrials {

  /*
  Problems with runnable:
a.) anybody can create a a lot of threads and have for example 1000 threads on the system, which may not be desirable.
b.) once the task is done , the thread dies.
c.) thread is an expensive resource.

In java ee applications , you are not allowed to create threads on your own.

improve use of thread resources - executor framework , ready to use threads.

Executors - Executor service - Executor

reactive programming -  https://blog.redelastic.com/what-is-reactive-programming-bc9fa7f4a7fc

In executor service , tasks are executed in order of submission.It internally maintains a queue of tasks.
A task can be removed from the queue if not started.

Runnables do not return anything
no checked exceptions can be thrown

executor.shutdown whouls be called in finally cause.

Cachedthread pool creates threads on demand
keeps unused threads for 60s, gould for lambda executions short duration many executions handling spikes.

scheduled thread pool executor , schedule task,delay.

schedule at fixed rate task,delay,period

shutdown -  complete current and waiting tasks, do not accept any new tasks.
   */


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      //first task
      Runnable task = () -> {
        System.out.println("######### Hello World");
        try {
          Thread.sleep(6000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      };
      //second task
      Runnable task2 = () -> {
        System.out.println("######## Hello world 2");
        try {
          Thread.sleep(6000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      };
      executorService.execute(task);
      //task2 will always happen after task guranteed , big advantage over using thread.start()
      executorService.execute(task2);
    /*
    Testing with futures and callables
     */
      Callable<String> longCompute = () -> {
        Thread.sleep(10000);
        return "############ Data is now available";
      };
      Future<String> result = executorService.submit(longCompute);
      while (!result.isDone()) {
        System.out.println("Waiting for data");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      try {
        System.out.println(result.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
      //Finding exceptionscthrouigh callable
      Callable<String> anotherLongCompute = () -> {
        return "Data now " + (5 / 0);
      };
      Future<String> result1 = executorService.submit(anotherLongCompute);
      try {
        System.out.println(result1.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
        System.out.println(e.getCause());
      }
    }finally {
      if (!executorService.isShutdown()) {
        executorService.shutdown();
      }
    }
  }
}
