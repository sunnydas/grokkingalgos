package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph{
	
	private int numberOfVertices;
	
	private List<List<Integer>> adjacencyMatrix;

	public Graph(int numberOfVertices) {
		super();
		this.numberOfVertices = numberOfVertices;
		this.adjacencyMatrix = new LinkedList<List<Integer>>();
		for(int i = 0 ; i <= numberOfVertices ; i++) {
			adjacencyMatrix.add(i, new LinkedList<Integer>());			
		}
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	@Override
	public String toString() {
		return "Graph [numberOfVertices=" + numberOfVertices + ", adjacencyMatrix=" + adjacencyMatrix + "]";
	}

	public List<List<Integer>> getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(List<List<Integer>> adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}	
	
	public void addEdge(int v,int w) {
		this.adjacencyMatrix.get(v).add(w);		
	}
	
}
public class DFS {
	
	/*
	 *   1 -> 2 
	 *     -> 3 -> 4
	 *        |
	 *        v
	 *        5 
	 */
	
	public static Graph createGraph(int numberOfVertices,
			String edgeString) {
		String[] edges = edgeString.split("\\s+");
		/*
		 *  1 2 3
		 *  3 4 5  
		 * 
		 */
		Graph graph = new Graph(numberOfVertices);
		for(int i = 0; i < edges.length ; i+=2) {
			graph.addEdge(Integer.parseInt(edges[i]), 
					Integer.parseInt(edges[i+1]));						
		}
		System.out.println(graph);
		return graph;
	}
	
	public static void dfsRecursive(Graph graph,
			int current,
			boolean[] visited) {
		visited[current] = true;
		List<Integer> adjacency = graph.getAdjacencyMatrix().get(current);
		if(!adjacency.isEmpty()) {
			for(Integer vertex : adjacency) {
				dfsRecursive(graph, vertex, visited);				
			}
		}
		System.out.println(current);
	}
	
	public static void dfs(int numberOfVertices,String edgeString) {
		Graph graph = createGraph(numberOfVertices, edgeString);
		boolean[] visited = new boolean[numberOfVertices+1];
		dfsRecursive(graph,1,visited);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String edgesString = "1 2 1 3 3 4 3 5";
		/*
		 *  1  ---> 2
		 *   | 
		 *   | 
		 *   v
		 *   3-------->4
		 *   |
		 *   v
		 *   5  
		 */
		//Graph graph = createGraph(5, edgesString);
		//System.out.println(graph);
		dfs(5, edgesString);
	}

}
