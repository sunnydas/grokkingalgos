package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

/**
 *
 */
class Score{
    int hits;

  @Override
  public String toString() {
    return "Score{" +
        "hits=" + hits +
        ", pseudoHits=" + pseudoHits +
        '}';
  }

  int pseudoHits;
}
/**
 * Created by sundas on 6/16/2018.
 */
public class MasterMind {

  /*
  copmpuer 4 slots:
  each slot might have:
  red,yellow,green blue  balls (RYGB)
  user is trying to guess which slot has what color for example:
  YRGB
  guessing correct color at correct slot you get a hit.
   If you guess a color that exists but in wrong slot u get a speudo hit.
   if computer = RGBY
   your guess = GGRR
   one hit and one pseudo hit.
   A hit sloy cannot be pseudo hit
   */

  /**
   *
   * @param actual
   * @param guess
   * @return
   */
  public static Score getScore(char[] actual,char[] guess){
    Score score = new Score();
    int hitCounter = 0;
    int pseudoHitCounter = 0;
    int i = 0;
    while(i < actual.length){
      if(actual[i] == guess[i]){
        hitCounter++;
        guess[i] = '0';
        actual[i] = '0';
      }
      i++;
    }
    i = 0;
    while(i < guess.length){
      char currentGuess = guess[i];
      if(currentGuess != '0'){
        for(int j = 0 ; j < actual.length ; j++){
          if(actual[j] != '0' &&
              currentGuess == actual[j]){
            actual[j] = '0';
            pseudoHitCounter++;
          }
        }
      }
      i++;
    }
    score.hits = hitCounter;
    score.pseudoHits = pseudoHitCounter;
    return score;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    char[] actual = new char[]{'R','G','B','Y'};
    char[] guess = new char[]{'G','G','R','R'};
    System.out.println(getScore(actual,guess));
  }
}
