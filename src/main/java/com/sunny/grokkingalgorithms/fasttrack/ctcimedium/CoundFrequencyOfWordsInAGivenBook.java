package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

import com.sunny.grokkingalgorithms.java.concurrency_2018.FileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 6/16/2018.
 */
public class CoundFrequencyOfWordsInAGivenBook {

  /*
  Count frequency of words in a given book
   */
  public static Map<String,Integer> wordCount(String fileName){
    Map<String,Integer> wordCount = new HashMap<>();
    File file = null;
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try{
      file = new File(fileName);
      fileReader = new FileReader(fileName);
      bufferedReader = new BufferedReader(fileReader);
      String line = null;
      while((line = bufferedReader.readLine()) != null){
        String[] splitted = line.split(" ");
        for(String s : splitted){
          if(wordCount.containsKey(s)){
            wordCount.put(s,wordCount.get(s) + 1);
          }
          else{
            wordCount.put(s,1);
          }
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    } finally {
      if(bufferedReader != null){
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return wordCount;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String filename = "data.txt";
    System.out.println(wordCount(filename));
  }

}
