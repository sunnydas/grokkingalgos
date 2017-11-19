package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.Scanner;
import java.util.Stack;
class ParenthesisClassElement{
  private int index;
  private char bracket;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  @Override
  public String toString() {
    return "ParenthesisClassElement{" +
        "index=" + index +
        ", bracket=" + bracket +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ParenthesisClassElement that = (ParenthesisClassElement) o;

    if (getIndex() != that.getIndex()) return false;
    return getBracket() == that.getBracket();

  }

  @Override
  public int hashCode() {
    int result = getIndex();
    result = 31 * result + (int) getBracket();
    return result;
  }

  public char getBracket() {

    return bracket;
  }

  public void setBracket(char bracket) {
    this.bracket = bracket;
  }
}
/**
 * Created by sundas on 11/17/2017.
 */
public class LongestValidParenthesis {

  /*
  http://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
   */

  /**
   *
   * @param parenthesisString
   * @return
   */
  public static int findLengthofLongestValidParenthesis(String parenthesisString){
    /*
    General explanation of solution:
    We have to find valid parenthesis sequences and choose the longest valid parenthesis. Let us take an example:
    Suppose we have an input sequence like:
    ()(()))))
    To aid us visually let us reconstruct it as:
    0  1  2  3  4  5  6  7  8
    (  ) (  (   )  )  )  )  )

    Since we know that parenthesis matching can be done using a stack But before that we create another array where we
    store the character and the corresponding index. I am modeling this using a java class (See: ParenthesisClassElement)
    the two main attributes of the class is the parenthesis character itself and the corresponding index. Something like:
    0        1       2      3        4       5         6      7       8
  (0,"(")  (1,")") (2,"(") (3,"(")  (4,")") (5,")")  (6,")") (7,")") (8,")")

    We have to see how e can do away with the above step.
    Now we start off with the standard parenthesis matching using the stack. We keep track of adjacent valid parentehsis using an array

    Let S = {(0,"(")} be the stack initial state
    step 1:  get next elem which is (1,")") , compare this with top of stack and find that it is a mathc so update the output array with teh corresponding indexes (this si available from the class
    elements itself).
    op = [1,1,0,0,0,0,0,0,0]
    step 2:  get next elem push (2,"(") to S
    step 3:  get next elem push (3,"(") to S
    step 4:  get next elem check with top of stack we have a valid parenthesis set , update output array
    op = [1,1,0,1,1,0,0,0,0]
    step 5:  get next elem check with top of stack we have a valid parenthesis set , update output array
    op = [1,1,1,1,1,1,0,0,0]
    step 6: get next elem push (6,")") to S
    step 7: get next elem push (7,")") to S
    step 8: get next elem push (7,")") to S
    FInal output array op = [1,1,1,1,1,1,0,0,0], count the longest valid parenthesis string which is 6.
     */
    int lengthOfLongestValidParenthesis = 0;
    Stack<ParenthesisClassElement> tracker = new Stack<>();
    /*
    The idea is that we use parenthesis matching bu keep track of indexes so that we can create a count.
     */
    /*
    This is a step where we populate the parenthesis array with placeholder objects.This will make it easy for
    finding adjacent complete brackets
     */
    ParenthesisClassElement[] placeHolders = new ParenthesisClassElement[parenthesisString.length()];
    for(int i = 0 ; i < placeHolders.length ; i++){
      ParenthesisClassElement element = new ParenthesisClassElement();
      element.setBracket(parenthesisString.charAt(i));
      element.setIndex(i);
      placeHolders[i] = element;
    }
    tracker.add(placeHolders[0]);
    int index = 1;
    int[] finalStitchedOutput = new int[placeHolders.length];
    while(index < placeHolders.length){
      if(placeHolders[index].getBracket() == '('){
        tracker.push(placeHolders[index]);
      }
      else if(placeHolders[index].getBracket() == ')'){
        if(!tracker.isEmpty() && tracker.peek().getBracket() == '('){
          ParenthesisClassElement p1 = tracker.pop();
          finalStitchedOutput[p1.getIndex()] = 1;
          finalStitchedOutput[index] = 1;
        }
        else{
          tracker.add(placeHolders[index]);
        }
      }
      index++;
    }
    /*
    Time for final counting
     */
    int curCount = 0;
    for(int i = 0 ; i < finalStitchedOutput.length ; i++){
      if(finalStitchedOutput[i] == 1){
        curCount++;
      }
      else if(finalStitchedOutput[i] == 0){
        if(curCount > 0 && curCount > lengthOfLongestValidParenthesis){
          lengthOfLongestValidParenthesis = curCount;
        }
        curCount = 0;
      }
    }
    // If the last two elements are a pair
    if(curCount > 0 && curCount > lengthOfLongestValidParenthesis){
      lengthOfLongestValidParenthesis = curCount;
      curCount = 0;
    }
    return lengthOfLongestValidParenthesis;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    //)(()()(()))))
    //)(((())(()()(()))))
    /*
    Input:
")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"
Output:
134
Expected:
132
))(())))()())((()))

0 1  2  3  4  5  6  7  8  9  10 11 12  13 14 15  16  17  18
) )  (  (  )  )  )  )  (  )  (  )  )   (  (  (   )   )   )

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
0 0 X X X X 0 0 X X  X  X  0  X  X  X  X  X  X
     */
    Scanner scanner = new Scanner(System.in);
    int numOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numOfTestCases ; i++){
      String parenthesisString = scanner.next();
      System.out.println(findLengthofLongestValidParenthesis(parenthesisString));
    }
  }
}
