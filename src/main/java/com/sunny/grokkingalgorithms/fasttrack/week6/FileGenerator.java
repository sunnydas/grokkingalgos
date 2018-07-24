package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Created by sundas on 7/24/2018.
 */
public class FileGenerator {

  /*
  Generate a file with one number occuring more than 50%
   */


  /**
   *
   * @param file
   * @throws Exception
   */
  public static void generateFile(String file) throws Exception {
    File outputFile = new File(file);
    FileWriter fileWriter = new FileWriter(outputFile);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    try{
      Random random = new Random(100);
      int num = random.nextInt(10000);
      int index = 0;
      while(index < 5500){
        bufferedWriter.write(""+num);
        bufferedWriter.newLine();
        index++;
      }
      while(index < 10000){
        bufferedWriter.write(""+random.nextInt(10000));
        bufferedWriter.newLine();
        index++;
      }
    }finally{
      bufferedWriter.flush();
      bufferedWriter.close();
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) throws Exception{
    generateFile("testdata");
  }

}
