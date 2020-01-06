package dataStructure;

import java.io.Serializable;
import java.util.*;


public class DGraph implements graph, Serializable {

	public HashMap<Integer,node_data> GraphMap = new HashMap<>();
	public HashMap<Integer,HashMap<Integer,edge_data>> edgeHM = new HashMap<Integer, HashMap<Integer, edge_data>>();
	public int EdgeSize = 0;
	public int keyCounter = 1 ;
	public int MC;

	public void init(String jsonFile){

	}
	/**
	 * reset use only for test!!!
	 */
	public void reset(){
		this.EdgeSize = 0;
		this.GraphMap.clear();
		this.edgeHM.clear();
		this.MC = 0;
		this.keyCounter = 1;
	}

	/**
	 *	func that return node my key. if not exist return null
	 * @param key - the node_id
	 * @return
	 */
	@Override
	public node_data getNode(int key) {
		if(!GraphMap.containsKey(key)) return null;
		return GraphMap.get(key);
	}

	/**
	 * function that return edge. if not exist return null
	 * @param src
	 * @param dest
	 * @return
	 */
	@Override
	public edge_data getEdge(int src, int dest) {

		if(this.edgeHM.get(src)==null){
			return null;
		}
		if(this.edgeHM.get(src).get(dest)==null){
			return null;
		}
		return this.edgeHM.get(src).get(dest);
	}

	private int getWieght(int src, int dest) {
		HashMap<Integer,edge_data> s = this.edgeHM.get(src);
		return (int)s.get(dest).getWeight();
	}

	/**
	 * function that add node
	 * @param n
	 */
	@Override
	public void addNode(node_data n) {
		MC++;
		this.GraphMap.put(keyCounter,n);
		((NodeData) n).setKey(keyCounter++);

	}

	/**
	 * function thar connect between 2 nodes
	 * @param src - the source of the edge.
	 * @param dest - the destination of the edge.
	 * @param w - positive weight representing the cost (aka time, price, etc) between src-->dest.
	 */
	@Override
	public void connect(int src, int dest, double w) {
		if(GraphMap.get(src) != null && GraphMap.get(dest) != null) {
			EdgeData edge = new EdgeData(src, dest, w);
			HashMap<Integer,edge_data> s = this.edgeHM.get(src);
			if(s==null){
				s = new HashMap<Integer,edge_data>();
				this.edgeHM.put(src,s);
			}
			if(this.edgeHM.get(src).containsKey(dest)){
				this.edgeHM.get(src).remove(dest);
				this.edgeHM.get(src).put(dest,edge);
			}
			else this.edgeHM.get(src).put(dest,edge);
			MC++;
			EdgeSize++;
		}
		else{
			System.out.println("src or dest is null");
		}
	}

	/**
	 * return all the nodes in the graph
	 * @return
	 */
	@Override
	public Collection<node_data> getV() {
		return GraphMap.values();
	}

	/**
	 * return add the edge how connect to node_id
	 * @param node_id
	 * @return
	 */
	@Override
	public Collection<edge_data> getE(int node_id) {
		if(!this.edgeHM.containsKey(node_id)) return null;
		if(this.edgeHM.get(node_id) == null) return null;
		return this.edgeHM.get(node_id).values();
	}

	/**
	 * function that remove nodes
	 * @param key
	 * @return
	 */
	@Override
	public node_data removeNode(int key) {
		if(GraphMap.containsKey(key)) {
			MC++;
			if (edgeHM.containsKey(key)) {
				Iterator<edge_data> iter = edgeHM.get(key).values().iterator();
				while (iter.hasNext()) {
					edge_data edge = iter.next();
					this.removeEdge(edge.getSrc(), edge.getDest());
					iter = edgeHM.get(key).values().iterator();
					EdgeSize--;
				}
				edgeHM.remove(key);
			}
			Iterator<node_data> iter2 = GraphMap.values().iterator();
			while (iter2.hasNext()) {
				node_data n = iter2.next();
				if (edgeHM.containsKey(n.getKey())) {
					if (edgeHM.get(n.getKey()).containsKey(key)) {
						edgeHM.get(n.getKey()).remove(key);
						EdgeSize--;
					}
				}
			}
			return GraphMap.remove(key);
		}
		return null;
	}

	/**
	 * function that remove edge
	 * @param src
	 * @param dest
	 * @return
	 */
	@Override
	public edge_data removeEdge(int src, int dest) {
		if(this.edgeHM.get(src).get(dest)!=null) {
			MC++;
			EdgeSize--;
			return this.edgeHM.get(src).remove(dest);
		}
		else return null;
	}

	@Override
	public int nodeSize() {
		return GraphMap.size();
	}

	@Override
	public int edgeSize() {
		return EdgeSize;
	}

	@Override
	public int getMC() {
		return this.MC;
	}
	public static String StringToHash(int src,int dest){
		return ""+src+","+dest;
	}
	public String toString(){
		return GraphMap.toString();
	}


	public static void main(String[] args) {

	}

}
