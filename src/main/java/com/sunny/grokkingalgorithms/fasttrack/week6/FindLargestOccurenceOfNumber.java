package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by sundas on 7/24/2018.
 */
public class FindLargestOccurenceOfNumber {

  /*
  Given a large file in which one no. occurs in strict majority(>50%).
  Find that no.
   */

  /**
   *
   * @param fileName
   * @return
   */
  public static long findNum(String fileName) throws Exception{
    long num = Long.MIN_VALUE;
    File file = new File(fileName);
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    Map<String,Long> tracker = new HashMap<>();
    String line = null;
    long numOfLines = 0;
    try (Stream<String> lines = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
      numOfLines = lines.count();
    }
    while((line = bufferedReader.readLine()) != null){
      if(tracker.containsKey(line.trim())){
        Long count = tracker.get(line.trim());
        count++;
        tracker.put(line.trim(),count);
        if(count > numOfLines/2){
          num = Long.parseLong(line.trim());
          break;
        }
      }
      else{
        tracker.put(line.trim(),1L);
      }
    }
    return num;
  }



  /**
   *
   * @param args
   */
  public static void main(String[] args) throws Exception{
    System.out.println(findNum("testdata"));
  }

}
