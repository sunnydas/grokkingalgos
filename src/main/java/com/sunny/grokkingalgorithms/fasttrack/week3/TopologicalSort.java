package com.sunny.grokkingalgorithms.fasttrack.week3;

import com.sunny.grokkingalgorithms.fasttrack.week3.graph.Graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by sundas on 7/2/2018.
 */
public class TopologicalSort {


  /**
   *
   * @param graph
   * @param stack
   * @param v
   * @param visited
   */
  public static void topoSortUtil(Graph graph,Stack<Integer> stack,int v,
                                  boolean[] visited){
    visited[v] = true;
    Iterator<Integer> adjacencyIterator = graph.getAdjacencyList()[v].iterator();
    while(adjacencyIterator.hasNext()){
      int i = adjacencyIterator.next();
      if(!visited[i]){
        topoSortUtil(graph,stack,i,visited);
      }
    }
    stack.push(v);
  }

  /**
   *
   * @param graph
   */
  public static void topologicalSort(Graph graph){
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[graph.getV()];
    for(int i = 0 ; i < graph.getV() ; i++){
      if(visited[i] == false){
        topoSortUtil(graph,stack,i,visited);
      }
    }
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Graph graph = new Graph(6);
    graph.addEdge(5, 2);
    graph.addEdge(5, 0);
    graph.addEdge(4, 0);
    graph.addEdge(4, 1);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);
    topologicalSort(graph);
  }


}
