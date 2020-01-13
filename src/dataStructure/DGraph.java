package dataStructure;


import gameClient.*;
import oop_elements.OOP_NodeData;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.*;
import java.io.*;
import java.util.*;


public class DGraph implements graph, Serializable {

	public HashMap<Integer,node_data> GraphMap = new HashMap<>();
	public HashMap<Integer,HashMap<Integer,edge_data>> edgeHM = new HashMap<Integer, HashMap<Integer, edge_data>>();
	public int EdgeSize = 0;
	public int keyCounter = 1;
	public int MC;
	private int type;
	private int count;

	public DGraph(int type) {
		this.init();
		this.type = type;
		this.count = 0;
		this.MC = 0;
	}
	private void init() {
		this.GraphMap = new HashMap();
		this.edgeHM = new HashMap();
	}
	public void init(String jsonSTR) {
		try {
			OOP_NodeData.resetCount();
			this.init();
			this.count = 0;
			JSONObject graph = new JSONObject(jsonSTR);
			JSONArray nodes = graph.getJSONArray("Nodes");
			JSONArray edges = graph.getJSONArray("Edges");

			int i;
			int s;
			for(i = 0; i < nodes.length(); ++i) {
				s = nodes.getJSONObject(i).getInt("id");
				String pos = nodes.getJSONObject(i).getString("pos");
				Point3D p = new Point3D(pos);
				this.addNode(new NodeData(p));
			}

			for(i = 0; i < edges.length(); ++i) {
				s = edges.getJSONObject(i).getInt("src");
				int d = edges.getJSONObject(i).getInt("dest");
				double w = edges.getJSONObject(i).getDouble("w");
				this.connect(s, d, w);
			}
		} catch (Exception var10) {
			var10.printStackTrace();
		}

	}
	public String toJSON() {
		JSONObject allEmps = new JSONObject();
		JSONArray VArray = new JSONArray();
		JSONArray EArray = new JSONArray();
		Collection<node_data> V = this.getV();
		Iterator<node_data> iter = V.iterator();
		Collection<edge_data> E = null;
		Iterator itr = null;

		try {
			while(iter.hasNext()) {
				node_data nn = (node_data) iter.next();
				int n = nn.getKey();
				String p = nn.getLocation().toString();
				JSONObject node = new JSONObject();
				node.put("id", n);
				node.put("pos", p);
				VArray.put(node);
				itr = this.getE(n).iterator();

				while(itr.hasNext()) {
					edge_data ee = (edge_data)itr.next();
					JSONObject edge = new JSONObject();
					edge.put("src", ee.getSrc());
					edge.put("dest", ee.getDest());
					edge.put("w", ee.getWeight());
					EArray.put(edge);
				}
			}

			allEmps.put("Nodes", VArray);
			allEmps.put("Edges", EArray);
		} catch (Exception var14) {
			var14.printStackTrace();
		}

		return allEmps.toString();
	}

	public DGraph(String file_name) {
		try {
			this.init();
			OOP_NodeData.resetCount();
			Scanner scanner = new Scanner(new File(file_name));
			String jsonString = scanner.useDelimiter("\\A").next();
			scanner.close();
			JSONObject graph = new JSONObject(jsonString);
			JSONArray nodes = graph.getJSONArray("Nodes");
			JSONArray edges = graph.getJSONArray("Edges");

			int i;
			int s;
			for(i = 0; i < nodes.length(); ++i) {
				//s = nodes.getJSONObject(i).getInt("id");
				String pos = nodes.getJSONObject(i).getString("pos");
				Point3D p = new Point3D(pos);
				this.addNode(new NodeData(p));
			}

			for(i = 0; i < edges.length(); ++i) {
				s = edges.getJSONObject(i).getInt("src");
				int d = edges.getJSONObject(i).getInt("dest");
				double w = edges.getJSONObject(i).getDouble("w");
				this.connect(s, d, w);
			}
		} catch (Exception var12) {
			var12.printStackTrace();
		}

	}
	public DGraph() {
		this(1);
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
		//p.SaveToJson("YALA");
	}

}
