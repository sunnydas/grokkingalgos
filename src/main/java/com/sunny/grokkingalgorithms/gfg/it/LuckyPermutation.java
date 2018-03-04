package com.sunny.grokkingalgorithms.gfg.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by sundas on 2/28/2018.
 */
public class LuckyPermutation {

  //https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/practice-problems/algorithm/micro-and-permutations/

  /*
  Micro is having a graph having N vertices numbered from 1 to N and M edges. All the edges are bidirectional. Micro wants to find out the number of lucky permutations in the graph.
A permutation of the vertices [v1,v2,v3,....,vn] is called lucky permutation, if for every vertex vi, where 1?i?N?1, there is an edge between vi and vi+1. Help Micro find out the number of lucky permutations in the graph.

Input:
First line consists of two space separated integers denoting N and M.
M lines follow each consisting of two space separated integers X and Y denoting there is an edge between vertices numbered X and Y.

Output:
Print the number of lucky permutations in the graph.

Constraints:
1?N?10
1?M?100
1?X,Y?N

SAMPLE INPUT
3 2
1 2
2 3
SAMPLE OUTPUT
2
Explanation
The two possible lucky permutations are 1-2-3 and 3-2-1.
   */

  /**
   *
   * @return
   */
  public static int countLuckyPermutation(int[][]  edgeMatrix){
    int luckyPermutation = 0;
    /*int[] inputVector = new int[edgeMatrix[0].length];
    Integer[] converted = Arrays.stream(inputVector).boxed().toArray(Integer[]::new);*/
    Integer[] converted = new Integer[edgeMatrix[0].length];
    for(int i = 0 ; i < edgeMatrix[0].length ; i++){
      converted[i] = i;
    }
    List<List<Integer>> allPermutations = generatePermutations(converted);
    List<List<Integer>> permutationsOfLengthN = new ArrayList<>();
    for(List<Integer> perm : allPermutations){
      if(perm.size() == edgeMatrix[0].length){
        permutationsOfLengthN.add(perm);
      }
    }
    //System.out.println(permutationsOfLengthN);
    for(List<Integer> perm : permutationsOfLengthN){
      boolean isLucky = true;
      for(int i = 1 ; i < perm.size() ; i++){
        if(edgeMatrix[perm.get(i)][perm.get(i-1)] != 1){
          isLucky = false;
          break;
        }
      }
      if(isLucky){
        luckyPermutation++;
      }
    }
    return luckyPermutation;
  }


  /**
   *
   * @param inputVector
   * @return
   */
  public static List<List<Integer>> generatePermutations(Integer[] inputVector){
    List<Integer> workingVector = new ArrayList<>(Arrays.asList(inputVector));
    //System.out.println(workingVector);
    //for(int i = 0 ; i < workingVector.size() ; i++) {
    List<List<Integer>> permutations = generatePermutationsRecursive(workingVector);
    //}
    return permutations;
  }

  /**
   *
   * @param workingVector
   * @return
   */
  public static List<List<Integer>> generatePermutationsRecursive(List<Integer> workingVector){
    //System.out.println(workingVector);
    /*
    This is the base case I am adding a sort of an identifier so that this can be used at higher levels
     */
    if(workingVector.size() == 0){
      List<List<Integer>> baseCasePermutations = new ArrayList<>();
      List<Integer> basecase = new ArrayList<>();
      basecase.add(Integer.MIN_VALUE);
      baseCasePermutations.add(basecase);
      return baseCasePermutations;
    }
    List<List<Integer>> permutations = new ArrayList<>();
    //Remove first element
    Integer current = workingVector.remove(0);
    List<List<Integer>> childPermutations = generatePermutationsRecursive(workingVector);
    //System.out.println(childPermutations);
    if(childPermutations.size() > 0){
      for(List<Integer> permutation: childPermutations){
        //System.out.println(permutation);
        /*
        Just append teh current to the list
         */
        if(permutation.size() == 1 && permutation.get(0) == Integer.MIN_VALUE){
          List<Integer> currentStage = new ArrayList<>();
          currentStage.add(current);
          permutations.add(currentStage);
        }else {
          /*
          Append current to all indexes
           */
          for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> permutationAtThisLevel = new ArrayList<>(permutation);
            permutationAtThisLevel.add(i, current);
            permutations.add(permutationAtThisLevel);
          }
          //permutations.addAll(childPermutations);
        }
      }
      permutations.addAll(childPermutations);
      //System.out.println(permutations);
    }
    return permutations;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*Scanner scanner = new Scanner(System.in);
    int noOfVertices = scanner.nextInt();
    int numberOfEdges = scanner.nextInt();
    //This matrix will be used to check if path exists
    int[][] edgeMatrix = new int[noOfVertices][noOfVertices];
    for(int i = 0; i < numberOfEdges ; i++){
      int source = scanner.nextInt();
      int target = scanner.nextInt();
      edgeMatrix[source - 1][target - 1] = 1;
      edgeMatrix[target - 1][source - 1] = 1;
    }
    System.out.println(countLuckyPermutation(edgeMatrix));*/
    /*Integer[]  inputVector = new Integer[]{1,2,3,4};
    List<List<Integer>> permutations = generatePermutations(inputVector);
    System.out.println(permutations.size());
    System.out.println(permutations);*/
    Scanner scanner = new Scanner(System.in);
    int noOfVertices = scanner.nextInt();
    int numberOfEdges = scanner.nextInt();
    //This matrix will be used to check if path exists
    int[][] edgeMatrix = new int[noOfVertices][noOfVertices];
    for(int i = 0; i < numberOfEdges ; i++){
      int source = scanner.nextInt();
      int target = scanner.nextInt();
      edgeMatrix[source - 1][target - 1] = 1;
      edgeMatrix[target - 1][source - 1] = 1;
    }
    System.out.println(countLuckyPermutation(edgeMatrix));
  }

}
