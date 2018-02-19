package com.sunny.grokkingalgorithms.java.concurrency_2018;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

class FileSearchTask implements Runnable{

  private LinkedBlockingQueue<File> workQueue;

  private String fileName;

  private volatile boolean found;

  public FileSearchTask(LinkedBlockingQueue<File> workQueue,String fileName,boolean found) {
    this.workQueue = workQueue;
    this.fileName = fileName;
    this.found = found;
  }

  public void run(){
    while(workQueue.size() > 0){
      File root = workQueue.poll();
      List<String> results = new ArrayList<>();
      FileSearch.searchFile(root,fileName,results);
      if(results.size() > 0){
        System.out.println("Found");
        System.out.println(results);
      }
    }
  }

}

/**
 * Created by sundas on 2/19/2018.
 */
public class FileSearchParallel {

  private static volatile boolean found;


  public static void searchFilesParallel(File rootFile,String fileName){
    int availProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println(availProcessors);
    File[] files = rootFile.listFiles();
    Thread[] myThreadPool  = new Thread[availProcessors];
    int tIndex = 0;
    LinkedBlockingQueue<File> workQueue = new LinkedBlockingQueue<>();
    if(files != null){
      for(File file : files){
        if(file.isDirectory()){
          workQueue.add(file);
        }
        else{
          if(file.getName().equals(fileName)){
            System.out.println("found file = " + file.getAbsolutePath());
            found = true;
          }
        }
      }
      for(int i = 0 ; i < myThreadPool.length ; i++){
        myThreadPool[i] = new Thread(new FileSearchTask(workQueue,fileName,found));
        myThreadPool[i].start();
      }
    }
  }




  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String fileDir = "";
    searchFilesParallel(new File(fileDir), "sunny.txt");
  }
}
