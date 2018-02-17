package com.sunny.grokkingalgorithms.gfg.ncr;

import java.util.Scanner;

/**
 * Created by sundas on 2/17/2018.
 */
public class RollOfDice {

  /*
  one input string
  one array contaiing dice ro;ll count
  like:
  s = abc
  roll[] = {3}
  s[0] = b
  s[1] = c
  s[2] = d
   */

  /**
   *
   * @param s
   * @param roll
   * @return
   */
  public static String diceRolledOutput(String s,int[] roll){
    StringBuilder mutated = new StringBuilder(s);
    /*
    We initiate a matrix like
    for s string abcd
     and roll[2] = {2,3}
    0   1    2    3
    1   1    0    0

  1 2   2    1    0


    which means a needs to rolled twice , b needs to be rolled twice , c needs to be rolled once and d needs to be rolled
    once giving:
    c d d d

Argument for O(n)
You loop over m, then for every loop iteration, you have an inner loop looping over m. This is m^2 or O(n^2).

Argument for O(n^2)
While you do have a double loop, after the algorithm executes fully, every single item of the input has been operated
upon only once each. Since the input n is what's used to determine runtime (as opposed to one dimension of
the input matrix, m), this is O(n). Note that since the input is defined to be a perfect square, the input size does
increase as m^2 (grows quadratically? Is that the right word?), but the runtime still increases linearly with the increase
of input size.
     */
    int[][] rollerMatrix = new int[roll.length][s.length()];
    int rIndex = 0;
    //O (mxn)
    /*
    It depends on what you call "n". It's O(n2) in the width or height of the matrix, but O(n) in the number of elements
    in the matrix. Since the number of elements in the matrix is the square of the width or height, it should be clear
     that both of these are the same.
Usually, the complexity is given in terms of "the size of the input"... which in this case, would be the number of
values
 in the matrix. So you'd call it O(n) in terms of the size of the input.
     */
    while(rIndex < roll.length){
      int rollCount = roll[rIndex];
      for(int cIndex = 0 ; cIndex < mutated.length() ; cIndex++) {
        int previousCount = 0;
        if (rIndex - 1 >= 0) {
          previousCount = rollerMatrix[rIndex - 1][cIndex];
        }
        int currentCount = 0;
        if(rollCount > 0){
          currentCount++;
        }
        rollerMatrix[rIndex][cIndex] = currentCount + previousCount;
        rollCount--;
      }
      rIndex++;
    }
    rIndex = rollerMatrix.length - 1;
    print2DMatrix(rollerMatrix);
    // O(m)
    for(int j = 0 ; j < mutated.length();j++){
      int rollCount = rollerMatrix[rIndex][j];
      if(rollCount > 0){
        char currentChar =  mutated.charAt(j);
        char newChar = 'a';
        // If the character is z you roll over to a
        if(currentChar != 'z') {
          newChar = (char) (currentChar + (char) (rollCount % 26));
        }
        mutated.replace(j,j+1,""+newChar);
        //System.out.println(mutated);
      }
    }
    return mutated.toString();
  }


  /**
   *
   * @param input
   */
  public static void print2DMatrix(int[][] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    abcd
2
2
3


aaa
10
3
3
3
3
3
3
3
3
3
3
1 1 1
2 2 2
3 3 3
4 4 4
5 5 5
6 6 6
7 7 7
8 8 8
9 9 9
10 10 10
kkk
     */
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    int n = scanner.nextInt();
    int[]  roll = new int[n];
    for(int i = 0 ; i < roll.length ; i++){
      roll[i] = scanner.nextInt();
    }
    System.out.println(diceRolledOutput(s,roll));
  }

}
