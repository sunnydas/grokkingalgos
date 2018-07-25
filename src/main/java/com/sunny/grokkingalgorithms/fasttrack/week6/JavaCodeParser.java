package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Stack;

/**
 * Created by sundas on 7/25/2018.
 */
public class JavaCodeParser {

  /*
   Write a parser which takes java file as input and
    give count of uncommented lines as output.
   */


  /**
   *
   * @param fileName
   * @throws Exception
   */
  public static void printCodeWithoutComments(String fileName)throws Exception{
    BufferedReader bufferedReader = getBufferedReader(fileName);
    String line = null;
    StringBuilder builder = new StringBuilder();
    Stack<String> stack = new Stack<>();
    try {
      while ((line = bufferedReader.readLine()) != null) {
        line = line.trim();
        if(line.startsWith("//")){
          continue;
        }
        else if(line.contains("//")){
          int index = line.indexOf("//");
          builder.append(line.substring(0,index));
          builder.append(System.getProperty("line.separator"));
        }
        else if(line.startsWith("/*")){
          stack.push("/*");
          if(line.endsWith("*/")){
            stack.pop();
          }
        }
        else if(line.contains("/*")){
          int index = line.indexOf("/*");
          builder.append(line.substring(0,index));
          builder.append(System.getProperty("line.separator"));
          stack.push("/*");
          if(line.endsWith("*/")){
            stack.pop();
          }
        }
        else if(line.endsWith("*/")){
          if(!stack.isEmpty()) {
            stack.pop();
          }
        }
        else{
          if(stack.isEmpty()) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
          }
        }
      }
    }finally {
      bufferedReader.close();
    }
    System.out.println(builder.toString());
  }

  public static BufferedReader getBufferedReader(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    return bufferedReader;
  }

  /**
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception{
    String fileName = "Test.java";
    printCodeWithoutComments(fileName);
  }

}
