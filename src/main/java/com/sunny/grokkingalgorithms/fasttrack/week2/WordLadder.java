package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.Arrays;
import java.util.Comparator;

class WordDistanceComparatoe
    implements Comparator<String>{


  @Override
  public int compare(String o1, String o2) {
    int sumO1 = 0;
    int sumO2 = 0;
    return calculateDistance(o1, o2, sumO1, sumO2);
  }

  public int calculateDistance(String o1, String o2, int sumO1, int sumO2) {
    sumO1 = getSum(o1, sumO1);
    for(int i = 0 ; i < o2.length() ; i++){
      sumO2 += '0' - o2.charAt(i);
    }
    return sumO1 - sumO2;
  }

  public static int getSum(String o1, int sumO1) {
    for(int i = 0 ; i < o1.length() ; i++){
      sumO1 += '0' - o1.charAt(i);
    }
    return sumO1;
  }
}
/**
 * Created by sundas on 6/25/2018.
 */
public class WordLadder {

  /*
  Word Ladder (Length of shortest chain to reach a target word)
Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.

Example:

Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN,TOON}
             start = TOON
             target = PLEA
Output: 7
Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
   */

  /**
   *
   * @param dictionary
   * @param start
   * @param target
   * @return
   */
  public static int findMinimum(String[] dictionary,
                                String start,
                                String target){
    int min = Integer.MAX_VALUE;
    Arrays.sort(dictionary, new WordDistanceComparatoe());
    boolean done = false;
    for(int i = 0 ; i < dictionary.length &&
        !done; i++){
      if(dictionary[i].equals(start)){
        int j = i + 1;
        int count = 0;
        for(;j < dictionary.length ; j++){
          int sum2 = WordDistanceComparatoe.getSum(dictionary[j],0);
          int sum1 = WordDistanceComparatoe.getSum(dictionary[j - 1],0);
          if(Math.abs(sum1 - sum2) <= 1){
            count++;
          }
          if(dictionary[j] == target){
            min = count;
            done = true;
            break;
          }
        }
      }
    }
    return min;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] dict = new String[]{
        "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN","TOON"
    };
    String start = "TOON";
    String target = "PLEA";
    System.out.println(findMinimum(dict,start,target));
  }

}
