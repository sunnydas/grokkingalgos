package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Scanner;

public class CrosswordPuzzle {
	
	/*
	 * A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. Cells marked with a - are to be filled with the word list.

The following shows an example crossword from the input  grid and the list of words to fit, :

Input 	   		Output

++++++++++ 		++++++++++
+------+++ 		+POLAND+++
+++-++++++ 		+++H++++++
+++-++++++ 		+++A++++++
+++-----++ 		+++SPAIN++
+++-++-+++ 		+++A++N+++
++++++-+++ 		++++++D+++
++++++-+++ 		++++++I+++
++++++-+++ 		++++++A+++
++++++++++ 		++++++++++
POLAND;LHASA;SPAIN;INDIA
Function Description

Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished puzzle.

crosswordPuzzle has the following parameter(s):

crossword: an array of  strings of length  representing the empty grid
words: a string consisting of semicolon delimited strings to fit into 
Input Format

Each of the first  lines represents , each of which has  characters, .

The last line contains a string consisting of semicolon delimited  to fit.

Constraints




Output Format

Position the words appropriately in the  grid, then return your array of strings for printing.

Sample Input 0

+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA
Sample Output 0

+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++
Sample Input 1

+-++++++++
+-++++++++
+-------++
+-++++++++
+-++++++++
+------+++
+-+++-++++
+++++-++++
+++++-++++
++++++++++
AGRA;NORWAY;ENGLAND;GWALIOR
Sample Output 1

+E++++++++
+N++++++++
+GWALIOR++
+L++++++++
+A++++++++
+NORWAY+++
+D+++G++++
+++++R++++
+++++A++++
++++++++++
Sample Input 2

XXXXXX-XXX
XX------XX
XXXXXX-XXX
XXXXXX-XXX
XXX------X
XXXXXX-X-X
XXXXXX-X-X
XXXXXXXX-X
XXXXXXXX-X
XXXXXXXX-X
ICELAND;MEXICO;PANAMA;ALMATY
Sample Output 2

XXXXXXIXXX
XXMEXICOXX
XXXXXXEXXX
XXXXXXLXXX
XXXPANAMAX
XXXXXXNXLX
XXXXXXDXMX
XXXXXXXXAX
XXXXXXXXTX
XXXXXXXXYX
	 */
	
	
	// Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
    	String[] results = new String[crossword.length];
    	char[][] cw = new char[crossword.length][crossword.length];
    	for(int i = 0 ; i < crossword.length ; i++) {
    		cw[i] = crossword[i].toCharArray();    		
    	}
        print(cw);
        String[] wordsArr = words.split(";");
    	return results;
    }
    
    static void completeCrossword(String[] crossword,String[] words,int i) {
    	if(words == null || words.length == 0) {
    		return;    		
    	}
    	
    }
    
    static void print(char[][] cw) {
    	for(int i = 0 ;i < cw.length ; i++) {
    		for(int j = 0 ; j < cw.length; j++) {
    			System.out.print(cw[i][j] + " ");    			
    		}
    		System.out.println();
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] results = crosswordPuzzle(crossword, words);

        for(String result : results) {
        	System.out.println(result);        	        	
        }
        

	}

}
