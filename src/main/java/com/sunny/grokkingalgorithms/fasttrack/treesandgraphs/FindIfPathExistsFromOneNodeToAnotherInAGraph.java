package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.fasttrack.treesandgraphs.utils.GraphNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 6/9/2018.
 */
public class FindIfPathExistsFromOneNodeToAnotherInAGraph {


  /**
   *
   * @param current
   * @param data (this is the next data we need to search)
   * @return
   */
  public static boolean checkIfPathExists(GraphNode current,int data){
    if(current == null){
      return false;
    }
    if(current.data == data){
      return true;
    }
    /*if(current.visited){
      return false;
    }*/
    current.visited = true;
    if(current.adjacencyList != null) {
      for (GraphNode next : current.adjacencyList) {
         boolean found =  checkIfPathExists(next,data);
        if(found){
          return found;
        }
      }
    }
    return false;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    1 -2 - 3 - 4
      - 6 - 5
     */
    GraphNode one = new GraphNode();
    one.data = 1;
    GraphNode two = new GraphNode();
    two.data = 2;
    GraphNode three = new GraphNode();
    three.data = 3;
    GraphNode four = new GraphNode();
    four.data = 4;
    GraphNode five = new GraphNode();
    five.data = 5;
    GraphNode six = new GraphNode();
    six.data = 6;
    List<GraphNode> onesAdjacent = new ArrayList<>();
    onesAdjacent.add(two);
    onesAdjacent.add(six);
    one.adjacencyList = onesAdjacent;
    List<GraphNode> twosAdjacent = new ArrayList<>();
    twosAdjacent.add(three);
    two.adjacencyList = twosAdjacent;
    List<GraphNode> threesAdjacent = new ArrayList<>();
    threesAdjacent.add(four);
    three.adjacencyList = threesAdjacent;
    List<GraphNode> sixsAdjacent = new ArrayList<>();
    sixsAdjacent.add(five);
    six.adjacencyList = sixsAdjacent;
    System.out.println(checkIfPathExists(one,4));
    System.out.println(checkIfPathExists(one,3));
    System.out.println(checkIfPathExists(one,2));
    System.out.println(checkIfPathExists(one,6));
    System.out.println(checkIfPathExists(one,5));
    System.out.println(checkIfPathExists(two,6));
    System.out.println(checkIfPathExists(two,5));
    System.out.println(checkIfPathExists(two,4));
    System.out.println(checkIfPathExists(two,3));
    System.out.println(checkIfPathExists(two,1));
    System.out.println(checkIfPathExists(three,5));
  }


}
