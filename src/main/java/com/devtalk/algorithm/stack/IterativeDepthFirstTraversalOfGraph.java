package com.devtalk.algorithm.stack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class IterativeDepthFirstTraversalOfGraph {

	static class Graph {
		int V; // Number of Vertices

		LinkedList<Integer>[] adj; // adjacency lists

		// Constructor
		Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];

			for (int i = 0; i < adj.length; i++)
				adj[i] = new LinkedList<Integer>();

		}

		// To add an edge to graph
		void addEdge(int v, int w) {
			adj[v].add(w); // Add w to v’s list.
		}

		public void DFS() {
			Map<Integer, Boolean> visitedArray = new HashMap();
			for (int i = 0; i < V; i++) {
				visitedArray.put(i, false);

			}
			
			for (int i = 0; i < V; i++) {
				if(!visitedArray.get(i)) {
					DFSUtil(i,visitedArray);
				}
			}


		}

		private void DFSUtil(int i, Map<Integer, Boolean> visitedArray) {
			Stack<Integer> st = new Stack();
			st.push(i);
			while(!st.isEmpty()) {
				i = st.pop();
				if(!visitedArray.get(i)) {
					System.out.println(i);
					visitedArray.put(i, true);
				}
				
				Iterator<Integer> itr = adj[i].iterator();
				while(itr.hasNext()) {
					int v = itr.next();
					if(!visitedArray.get(v)) {
						st.push(v);
					}
					
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		g.addEdge(4, 0);

		System.out.println("Following is Depth First Traversal");
		g.DFS();

	}

}
