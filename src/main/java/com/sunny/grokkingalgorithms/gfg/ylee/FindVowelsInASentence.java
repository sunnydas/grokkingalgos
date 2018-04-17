package com.sunny.grokkingalgorithms.gfg.ylee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sundas on 4/18/2018.
 */
public class FindVowelsInASentence {


  /**
   *
   * @param sentence
   * @return
   */
  public static List<String> findVowelsInASentence(String sentence){
    List<String> wordsWithFirstLetterAsVowels = new ArrayList<>();
    String[] splitted = sentence.split(" ");
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    for(String word: splitted){
      if(vowels.contains(Character.toLowerCase(word.charAt(0)))){
        wordsWithFirstLetterAsVowels.add(word);
      }
    }
    return wordsWithFirstLetterAsVowels;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String sentence = "Brown cat jumped over the fence and then jumped backe in again.";
    System.out.println(findVowelsInASentence(sentence));
  }
}
