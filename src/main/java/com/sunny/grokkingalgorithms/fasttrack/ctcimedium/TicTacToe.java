package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

/**
 * Created by sundas on 6/16/2018.
 */
public class TicTacToe {

  /*
  design an algorithm to find out if someone has won a game of
  tic tac toe
   */

  /**
   * Check if someone has won a game of tic tac toe
   *
   * @param ticTacToe
   * @param player
   * @return
   */
  public static boolean hasWon(String[][] ticTacToe,
                               String player){
    boolean won = false;
    if(ticTacToe != null && (player.equals("X")
        || player.equals("0"))){
      /*
      Check row 1 horizontal
       */
      int count = 0;
      for(int j = 0 ; j < ticTacToe[0].length ; j++){
        if(ticTacToe[0][j].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check row 2 horizontal
       */
      for(int j = 0 ; j < ticTacToe[0].length ; j++){
        if(ticTacToe[1][j].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check row 3 horizontal
       */
      for(int j = 0 ; j < ticTacToe[0].length ; j++){
        if(ticTacToe[2][j].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check column 1 vertical
       */
      for(int i = 0 ; i < ticTacToe.length ; i++){
        if(ticTacToe[i][0].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check column 2 vertical
       */
      for(int i = 0 ; i < ticTacToe.length ; i++){
        if(ticTacToe[i][1].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check column 3 vertical
       */
      for(int i = 0 ; i < ticTacToe.length ; i++){
        if(ticTacToe[i][2].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check right diagonal
       */
      for(int i = 0 ; i < ticTacToe.length ; i++){
        if(ticTacToe[i][i].equals(player)){
          count++;
        }
      }
      if(count == 3){
        won = true;
        return won;
      }
      count = 0;
      /*
      Check left diagonal
       */
      int j = ticTacToe.length - 1;
      for(int i = 0; i < ticTacToe.length; i++){
        if(ticTacToe[i][j].equals(player)){
          count++;
        }
        j--;
      }
      if(count == 3){
        won = true;
        return won;
      }
    }
    return won;
  }

  public static void main(String[] args) {
    String[][] tictacToe = new String[3][3];
    tictacToe = new String[][]{
        {"X","0","X"},
        {"0","X","0"},
        {"0","0","X"},
    };
    System.out.println(hasWon(tictacToe,"X"));
    System.out.println(hasWon(tictacToe,"0"));
    tictacToe = new String[][]{
        {"0","0","0"},
        {"0","X","0"},
        {"0","0","X"},
    };
    System.out.println(hasWon(tictacToe,"X"));
    System.out.println(hasWon(tictacToe,"0"));
    tictacToe = new String[][]{
        {"0","0","X"},
        {"0","X","X"},
        {"X","0","0"},
    };
    System.out.println(hasWon(tictacToe,"X"));
    System.out.println(hasWon(tictacToe,"0"));
    tictacToe = new String[][]{
        {"0","0","X"},
        {"0","X","X"},
        {"0","0","0"},
    };
    System.out.println(hasWon(tictacToe,"X"));
    System.out.println(hasWon(tictacToe,"0"));
  }

}
