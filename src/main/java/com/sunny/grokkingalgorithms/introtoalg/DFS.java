package com.sunny.grokkingalgorithms.introtoalg;

import java.util.Arrays;
import java.util.Stack;

class GraphNode{
    private GraphNode[] edges;
    private String weight;
    private boolean visited;

  public GraphNode(GraphNode[] edges, String weight, boolean visited) {
    this.edges = edges;
    this.weight = weight;
    this.visited = visited;
  }

  @Override
  public String toString() {
    return "GraphNode{" +
        "edges=" + Arrays.toString(edges) +
        ", weight=" + weight +
        ", visited=" + visited +
        '}';
  }

  public GraphNode[] getEdges() {
    return edges;
  }

  public GraphNode() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GraphNode graphNode = (GraphNode) o;

    if (getWeight() != graphNode.getWeight()) return false;
    if (isVisited() != graphNode.isVisited()) return false;
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    return Arrays.equals(getEdges(), graphNode.getEdges());

  }

  @Override
  public int hashCode() {
    int result = getEdges() != null ? Arrays.hashCode(getEdges()) : 0;
    result = 31 * result + getWeight().hashCode();
    result = 31 * result + (isVisited() ? 1 : 0);
    return result;
  }

  public void setEdges(GraphNode[] edges) {

    this.edges = edges;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}
/**
 * Created by sundas on 6/4/2017.
 */
public class DFS {

  /**
   *
   *
   * @param root
   */
  public static void preOrder(GraphNode root){
    if(root == null){
      return;
    }
    System.out.println(root.getWeight());
    root.setVisited(true);
    if(root.getEdges() != null){
      for(GraphNode child : root.getEdges()){
        if(!child.isVisited()){
          preOrder(child);
        }
      }
    }
  }


  /**
   *
   * @param root
   */
  public static void dfs(GraphNode root){
    Stack<GraphNode> operandStack = new Stack<>();
    operandStack.push(root);
    while(!operandStack.isEmpty()){
      GraphNode node = operandStack.pop();
      System.out.println(node.getWeight());
      node.setVisited(true);
      if(node.getEdges() != null){
        for(GraphNode child : node.getEdges()){
          if(!child.isVisited()) {
            operandStack.push(child);
          }
        }
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    GraphNode root = new GraphNode();
    root.setWeight("A");
    GraphNode b = new GraphNode();
    b.setWeight("B");
    GraphNode c = new GraphNode();
    c.setWeight("C");
    GraphNode[] edgesOfRoot = new GraphNode[]{b,c};
    root.setEdges(edgesOfRoot);
    GraphNode d = new GraphNode();
    d.setWeight("D");
    GraphNode e = new GraphNode();
    e.setWeight("E");
    GraphNode f = new GraphNode();
    f.setWeight("F");
    GraphNode[] edgesOfb = new GraphNode[]{d,e};
    b.setEdges(edgesOfb);
    GraphNode g = new GraphNode();
    g.setWeight("G");
    GraphNode h = new GraphNode();
    h.setWeight("H");
    GraphNode i = new GraphNode();
    i.setWeight("I");
    GraphNode[] edgesOfC = new GraphNode[]{e,f};
    c.setEdges(edgesOfC);
    GraphNode[] edgesOfD = new GraphNode[]{g};
    d.setEdges(edgesOfD);
    GraphNode[] edgesOfF = new GraphNode[]{g,h,i};
    f.setEdges(edgesOfF);
    GraphNode[] edgesOfG = new GraphNode[]{d};
    g.setEdges(edgesOfG);
    //preOrder(root);
    System.out.println("----------------------------------------------");
    dfs(root);
  }

}
