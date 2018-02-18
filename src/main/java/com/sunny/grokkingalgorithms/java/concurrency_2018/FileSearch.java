package com.sunny.grokkingalgorithms.java.concurrency_2018;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 2/19/2018.
 */
public class FileSearch {

  // Search a particular file identified by file name


  public static List<String>  searchFile(File rootFile,String fileName,List<String> results){
    if(rootFile == null){
      return results;
    }
    if(rootFile.getName().equals(fileName)){
      results.add(rootFile.getAbsolutePath());
      return results;
    }
    if(rootFile.listFiles() != null) {
      for (File file : rootFile.listFiles()) {
        results = searchFile(file, fileName, results);
      }
    }
    return results;
  }


  public static void main(String[] args) {
    String fileDir = "<insert path>";
    System.out.println(searchFile(new File(fileDir),"sunny.txt", new ArrayList<>()));
  }
}
