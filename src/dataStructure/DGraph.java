package dataStructure;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import utils.*;

import java.io.*;
import java.util.*;


public class DGraph implements graph, Serializable {

	public HashMap<Integer,node_data> GraphMap = new HashMap<>();
	public HashMap<Integer,HashMap<Integer,edge_data>> edgeHM = new HashMap<Integer, HashMap<Integer, edge_data>>();
	public int EdgeSize = 0;
	public int keyCounter = 1 ;
	public int MC;
//	public void drawFunctions(String json_file) {
//		Gson json = new Gson();
//		try{
////			FileReader filereader = new FileReader(json_file);
////			JsonParametrs parm = json.fromJson(filereader,JsonParametrs.class);
////			Range rx = new Range(parm.Range_X[0],parm.Range_X[1]);
////			Range ry = new Range(parm.Range_Y[0],parm.Range_Y[1]);
////			drawFunctions(parm.Width,parm.Height,rx,ry,parm.Resolution);
////		}
//		catch(FileNotFoundException|IllegalArgumentException |com.google.gson.JsonSyntaxException|com.google.gson.JsonIOException e){
//			System.out.println("The Json file is not correct, drawing diff");
//			this.drawFunctions();
//		}
//	}
	public void init(String jsonFile){
		Gson json = new Gson();
		try{
			FileReader filereader = new FileReader(jsonFile);
			JsonParametrs parm = json.fromJson(filereader,JsonParametrs.class);
			this.GraphMap = parm.GraphMap;
			this.edgeHM = parm.edgeHM;
			this.EdgeSize = parm.EdgeSize;
			this.keyCounter = parm.keyCounter;
			this.MC = parm.MC;
		}
		catch(IllegalArgumentException | JsonSyntaxException | JsonIOException | FileNotFoundException e){
			System.out.println("The Json file is not correct, drawing diff");
		}
	}
	public void SaveToJson(String file_name) throws IOException {
		Gson gson = new Gson();

		JsonParametrs obj = new JsonParametrs();
		obj.MC = 3 ;
		obj.EdgeSize = 8 ;
		obj.GraphMap = new HashMap<Integer, node_data>();
		obj.GraphMap.put(1,new NodeData(1,1,1));
		// 1. Java object to JSON file

		gson.toJson(obj, new FileWriter(file_name));

		// 2. Java object to JSON string
		String jsonInString = gson.toJson(obj);

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


	public static void main(String[] args) throws IOException {
		DGraph p = new DGraph() ;
		NodeData q = new NodeData(1,1,1);
		p.addNode(q);
		p.SaveToJson("YALA");
	}

}
