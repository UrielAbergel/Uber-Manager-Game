package algorithms;
/**
 * This interface represents the "regular" Graph Theory algorithms including:
 * 0. clone();
 * 1. init(String file_name);
 * 2. save(String file_name);
 * 3. isConnected();
 * 5. double shortestPathDist(int src, int dest);
 * 6. List<Node> shortestPath(int src, int dest);
 *
 * @author boaz.benmoshe
 *
 */

import java.util.List;

import dataStructure.graph;
import dataStructure.node_data;

public interface graph_algorithms {
	/**
	 * Init this set of algorithms on the parameter - graph.
	 * @param g
	 */
	public void init(graph g);
	/** 
	 * Compute a deep copy of this graph.
	 * @return
	 */
	public graph copy();
	/**
	 * Init a graph from file
	 * @param file_name
	 */
	public void init(String file_name);
	/** Saves the graph to a file.
	 * 
	 * @param file_name
	 */
	public void save(String file_name);
/**
 * Returns true if and only if (iff) there is a valid path from EVREY node to each
 * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
 * @return
 */
	public boolean isConnected();
	/**
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	public double shortestPathDist(int src, int dest);
	/**
	 * returns the the shortest path between src to dest - as an ordered List of nodes:
	 * src--> n1-->n2-->...dest
	 * see: https://en.wikipedia.org/wiki/Shortest_path_problem
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	public List<node_data> shortestPath(int src, int dest);
	/**
	 * computes a relatively short path which visit each node in the targets List.
	 * Note: this is NOT the classical traveling salesman problem, 
	 * as you can visit a node more than once, and there is no need to return to source node - 
	 * just a simple path going over all nodes in the list. 
	 * @param targets
	 * @return
	 */
	public List<node_data> TSP(List<Integer> targets);
}
