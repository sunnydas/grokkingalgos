package com.sunny.grokkingalgorithms.gpn;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  /*
   * Complete the function below.
   */
  static int[] get_ranks(String[] words) {
    int[] rank = new int[words.length];
    for(int i = 0 ; i < words.length ; i++){
      List<String> permutations = generateAllPermutations(words[i]);
      //System.out.println(permutations);
      Set<String> permutationsOfLengthN = new TreeSet<>();
      //System.out.println(permutationsOfLengthN);
      for(String perm : permutations){
        if(perm.length() == words[i].length()){
          permutationsOfLengthN.add(perm);
        }
      }
      //System.out.println(permutationsOfLengthN);
      //Collections.sort(permutationsOfLengthN);
      System.out.println(permutationsOfLengthN);
      Iterator<String> setIterator = permutationsOfLengthN.iterator();
      int index = 0;
      while(setIterator.hasNext()){
        if(setIterator.next().equals(words[i])){
          rank[i] = index;
          break;
        }
        index++;
      }
    }
    return rank;
  }

  static List<String> generateAllPermutations(String s){
    if(s.equals("")){
      List<String> baseCase = new ArrayList();
      baseCase.add("");
      return baseCase;
    }
    char currentChar = s.charAt(0);
    List<String> currentStagePermutations = new ArrayList();
    List<String> childPermutations = generateAllPermutations(s.substring(1));
    if(childPermutations.size() > 0 && !childPermutations.get(0).equals("")){
      for(String childPerm : childPermutations){
        for(int i = 0 ; i <= childPerm.length() ; i++){
          StringBuilder curStagePerm = new StringBuilder(childPerm);
          curStagePerm.insert(i,currentChar);
          currentStagePermutations.add(curStagePerm.toString());
        }
      }
      currentStagePermutations.addAll(childPermutations);
    }
    else if(childPermutations.size() == 1 && childPermutations.get(0).equals("")){
      currentStagePermutations.add(""+currentChar);
      currentStagePermutations.addAll(childPermutations);
    }
    //System.out.println(currentStagePermutations);
    return currentStagePermutations;
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = null;
    if (fileName != null) {
      bw = new BufferedWriter(new FileWriter(fileName));
    }
    else {
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    int[] res;
    int words_size = 0;
    words_size = Integer.parseInt(in.nextLine().trim());

    String[] words = new String[words_size];
    for(int i = 0; i < words_size; i++) {
      String words_item;
      try {
        words_item = in.nextLine();
      } catch (Exception e) {
        words_item = null;
      }
      words[i] = words_item;
    }

    res = get_ranks(words);
    for(int res_i = 0; res_i < res.length; res_i++) {
      bw.write(String.valueOf(res[res_i]));
      bw.newLine();
    }

    bw.close();
  }
}

