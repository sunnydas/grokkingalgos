package com.sunny.grokkingalgorithms.fasttrack.week3.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sundas on 7/2/2018.
 */
public class Graph {

  public int getV() {
    return v;
  }

  private int v;

  public List<Integer>[] getAdjacencyList() {
    return adjacencyList;
  }

  private List<Integer>[] adjacencyList;

  /**
   *
   * @param v
   */
  public Graph(int v) {
    this.v = v;
    adjacencyList = new List[v];
    for(int i = 0 ; i < v; i++){
      adjacencyList[i] = new LinkedList<>();
    }
  }

  /**
   *
   * @param v
   * @param w
   */
  public void addEdge(int v, int w){
    adjacencyList[v].add(w);
  }
}
