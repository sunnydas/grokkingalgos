package com.sunny.grokkingalgorithms.princeton.courses.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sundas on 2/8/2018.
 */
public class ThreeSumBruteForce {
  /*
  3-SUM. Given N distinct integers, how many triples sum to exactly zero?
   */


  /**
   *
   * @param input
   * @return
   */
  public static int countThreeSums(int[] input){
    int threeSums = 0;
    for(int i = 0 ; i < input.length ; i++){
      for(int j = i + 1; j < input.length ; j++){
        for(int k = j+1 ; k < input.length; k++){
          if((input[i] + input[j] + input[k]) == 0){
            threeSums++;
          }
        }
      }
    }
    return threeSums;
  }

  /**
   *
   * @param input
   * @return
   */
  public static int[] getIntegerInput(String[] input){
    int[] output = new int[input.length];
    for(int i = 0 ; i < input.length ; i++){
      output[i] = Integer.parseInt(input[i]);
    }
    return output;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String fileName = "data.txt";
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      fileReader = new FileReader(new File(fileName));
      bufferedReader = new BufferedReader(fileReader);
      String line = null;
      while((line = bufferedReader.readLine()) != null){
        String[] parsed = line.trim().split(" ");
        int[] input = getIntegerInput(parsed);
        System.out.println(countThreeSums(input));
      }
    } catch(IOException e){
      e.printStackTrace();
    } finally{
      if(bufferedReader != null){
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

}
