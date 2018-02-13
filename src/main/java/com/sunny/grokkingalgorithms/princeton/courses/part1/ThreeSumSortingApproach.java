package com.sunny.grokkingalgorithms.princeton.courses.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by sundas on 2/13/2018.
 */
public class ThreeSumSortingApproach {


  /**
   * This uses a sorting approach and finds pairs and then uses binary search to find a number qhich is the negation of the
   * sum of the pair.
   *
   *
   * @param input
   * @return
   */
  public static int countThreeSums(int[] input){
    int count = 0;
    // sort the array
    Arrays.sort(input);
    // Find pairs
    for(int i = 0; i < input.length - 1 ; i++){
       for(int j = i+1; j < input.length ; j++){
         int sum = input[i] + input[j];
         //Is there an element which equals to -sum ?
         // Use binary search
         int foundIndex = findElemBinarySearch(input,i,j,-sum);
         //  very important check a[i] < a[j] < a[k] to avoid double counting.:
         if(foundIndex > 0 && (input[i] < input[j]) && (input[j] < input[foundIndex])){
           //System.out.println(foundIndex);
           count++;
         }
       }
    }
    return count;
  }

  /**
   *
   * @param input
   * @param i
   * @param j
   * @param key
   * @return
   */
  public static int findElemBinarySearch(int[] input,int i,int j,int key){
    int index = -1;
    int startPtr = 0;
    int endPtr = input.length - 1;
    while(startPtr <= endPtr){
      int mid = startPtr + (endPtr - startPtr)/2;
      if(input[mid] == key){
        index = mid;
        break;
      }
      else if(input[mid] < key){
        startPtr = mid + 1;
      }
      else if(input[mid] > key){
        endPtr = mid - 1;
      }
    }
    return index;
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
