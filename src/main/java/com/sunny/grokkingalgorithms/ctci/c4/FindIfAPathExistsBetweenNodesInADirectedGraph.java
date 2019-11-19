package com.sunny.grokkingalgorithms.ctci.c4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 3/19/2018.
 */
public class FindIfAPathExistsBetweenNodesInADirectedGraph {

  /*
  Given a 2d matrix which represents a directed graph. Try to find out if a path exists between two nodes
   */

  /*
  This is just to track paths. This can be used to print the path
   */
  private static List<String> pathList = new ArrayList<>();

  /**
   *
   * @param graph
   * @param start
   * @param finish
   * @return
   */
   public static boolean pathExists(int[][] graph,int start,int finish){
     boolean pathExists = false;
     pathExists = pathExistsRecursive(graph,start,start,finish,"");
     return pathExists;
   }


  /**
   *
   * @param graph
   * @param from
   * @param to
   * @param finish
   * @return
   */
   public static boolean pathExistsRecursive(int[][] graph,int from,int to,int finish,String pathInfo){
     /*
     Path found since we have reached the last next
      */
     if(to == finish){
       /*
       We still need to worry about whether there is a path
        */
       if(graph[from][to] == 1) {
         pathInfo += to;
         pathList.add(pathInfo);
         return true;
       }
     }
     /*
     Is there a path from to to?,if not no point continuing further
      */
     if(graph[from][to] == 0){
       return false;
     }
     from = to;
     /*
     This is where the magic shiuld happen. Fnd all possible paths.
     We use a tow down approach to reach the end next
      */
     pathInfo += from + "->";
     /*
     All possible paths
      */
     for(int i = from + 1; i <= finish ; i++) {
       boolean pathExists = pathExistsRecursive(graph, from, i, finish,pathInfo);
       /*
       If path exists no need to probe further.
        */
       if(pathExists){
         return true;
       }
     }
     /*
     Have tried everything no paths found
      */
     return false;
   }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] graph = new int[][]{
        {1,1,1,0},
        {0,1,0,1},
        {0,0,1,1},
        {0,0,0,1}
    };
    /*
    Assuming 0 based numbering
     */
    System.out.println(pathExists(graph,0,3));
    System.out.println(pathList);
    pathList.clear();
    System.out.println(pathExists(graph, 1, 2));
    System.out.println(pathList);
    pathList.clear();
    System.out.println(pathExists(graph, 2, 3));
    System.out.println(pathList);
    pathList.clear();
    System.out.println(pathExists(graph, 0, 2));
    System.out.println(pathList);
    pathList.clear();
    System.out.println(pathExists(graph, 0, 1));
    System.out.println(pathList);
    pathList.clear();
    System.out.println(pathExists(graph, 3, 0));
    System.out.println(pathList);
  }

}
