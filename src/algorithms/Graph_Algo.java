package algorithms;

import java.io.*;
import java.util.*;

import dataStructure.*;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import javax.swing.*;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author
 *
 */
public class Graph_Algo implements graph_algorithms{
	private graph graph = new DGraph();
	public Graph_Algo(graph graph) {
		this.init(graph);
	}
	public Graph_Algo() {

	}
	public graph getGraph(){
		return this.graph;
	}

	/**
	 * init by graph
	 * @param g
	 */
	@Override
	public void init(graph g) {
		this.graph =  g;
	}

	/**
	 * init by file name
	 * @param file_name
	 */
	@Override
	public void init(String file_name) {
		try
		{
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(file);
			this.init((graph)in.readObject());

			in.close();
			file.close();

			System.out.println("Object has been deserialized");
		}
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}

		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}

	}

	/**
	 * save to file
	 * @param file_name
	 */
	@Override
	public void save(String file_name) {
		try
		{
			FileOutputStream file = new FileOutputStream(file_name);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.getGraph());
			out.close();
			file.close();

			System.out.println("Object has been serialized");
		}
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}

	}

	/**
	 * check if the graph is connected
	 * @return
	 */
	@Override
	public boolean isConnected() {
		boolean flag = true;
		Iterator<node_data> iter = this.getGraph().getV().iterator();
		while(iter.hasNext()){
			node_data thenewOne = iter.next();
			isConnectedRec(thenewOne);
			Iterator <node_data> iter2 = this.getGraph().getV().iterator();
			while(iter2.hasNext()){
				node_data corrent = iter2.next();
				if(corrent.getTag()!=1) flag = false;
				corrent.setTag(0);
			}
		}
		ChangeTheTag();
		return flag;
	}

	/**
	 * recursive function for isConnected
	 * @param thenewOne
	 */
	private void isConnectedRec(node_data thenewOne) {
		//thenewOne = (NodeData)thenewOne;
		if(thenewOne.getTag()==1) return;
		thenewOne.setTag(1);
		if(this.getGraph().getE(thenewOne.getKey()) == null) return;
		for(edge_data edge : this.getGraph().getE(thenewOne.getKey())){
			int dest = edge.getDest();
			isConnectedRec(this.getGraph().getNode(dest));
		}
	}

	/**
	 * function that get list of nodes and return list of their keys
	 * @param p
	 * @return
	 */
	public ArrayList<Integer> MakeListInt(List<node_data> p ){
		ArrayList<Integer> ans = new ArrayList<>();
		Iterator<node_data> iter = p.iterator();
		while (iter.hasNext()){
			ans.add(iter.next().getKey());
		}
		return  ans;
	}

	/**
	 * function that return the shortest distance between 2 points.
	 * if now exist return -1 (or infinity)
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	public double shortestPathDist(int src, int dest) {
		if(src == dest) return 0;
		for (node_data nodes : this.getGraph().getV()){
			nodes.setWeight(Integer.MAX_VALUE);
			nodes.setTag(0);
		}
		try {
			node_data theCurrenSrc = this.getGraph().getNode(src);
			theCurrenSrc.setWeight(0);
			int min = theCurrenSrc.getKey();
			while (min != dest) {
				min = CheckWhatMin();
				this.getGraph().getNode(min).setTag(1);
				if (this.getGraph().getE(min) != null) {
					if (this.getGraph().getE(min).iterator() != null) {
						Iterator<edge_data> iterEdges = this.getGraph().getE(min).iterator();
						while (iterEdges.hasNext()) {
							edge_data theCurrentEdge = iterEdges.next();
							node_data CurrentSrc = this.getGraph().getNode(theCurrentEdge.getSrc());
							node_data CurrentDest = this.getGraph().getNode(theCurrentEdge.getDest());
							if (CurrentSrc.getWeight() + theCurrentEdge.getWeight() < CurrentDest.getWeight()) {
								CurrentDest.setWeight(CurrentSrc.getWeight() + theCurrentEdge.getWeight());
							}
						}
					}
				}
			}
			double ans = this.getGraph().getNode(dest).getWeight();
			return ans;


		}catch (Exception e){
			System.out.println("Cannot get to dest");
			return -1;
		}
	}

	/**
	 * function that return the key who has the minimum weight
	 * @return
	 */
	private int CheckWhatMin() {
		Iterator<node_data> iter = this.getGraph().getV().iterator();
		double min = Integer.MAX_VALUE;
		int theGoodKey = 0;
		while (iter.hasNext()){
			node_data current = iter.next();
			if( current.getTag() == 0 && current.getWeight() <= min)
			{
				min = current.getWeight();
				theGoodKey = current.getKey();
			}
		}
		return theGoodKey;
	}

	/**
	 * private function that reset all the node weight to MAX_VALUE
	 */
	private void resetWeightToDones() {
		Iterator<node_data> iter = this.getGraph().getV().iterator();
		while(iter.hasNext()){
			node_data n = iter.next();
			n.setWeight(Integer.MAX_VALUE);
		}
	}

	/**
	 * function that return the shortest path between two nodes
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		try {
			ArrayList<node_data> SPArrays = new ArrayList<>();
			double flag = shortestPathDist(src, dest);
			if(flag == Integer.MAX_VALUE || flag == -1) return null;
			graph CopyGraph = this.copy();
			CopyGraph = changeDir(CopyGraph);
			SPArrays = ReturnTheSPway(dest, src, CopyGraph);
			SPArrays = ReverseArrays(SPArrays);
			ChangeTheTag();
			ChangeTheTagToEdge();
			resetWeightToDones();
			return SPArrays;
		}
		catch (Exception e){
			return null;
		}
	}

	/**
	 * function that revers the array list
	 * @param spArrays
	 * @return
	 */
	private ArrayList<node_data> ReverseArrays(ArrayList<node_data> spArrays) {
		ArrayList<node_data> theGoodCopy = new ArrayList<>();
		for (int i = spArrays.size()-1; i >= 0; i--) {
			theGoodCopy.add(spArrays.get(i));
		}
		return theGoodCopy;
	}

	/**
	 * private function for shortestPath
	 * @param src
	 * @param dest
	 * @param copyGraph
	 * @return
	 */
	private ArrayList<node_data> ReturnTheSPway(int src, int dest, graph copyGraph) {
		ArrayList<node_data> SaveTheWay = new ArrayList<>();
		node_data source = copyGraph.getNode(src);
		while(src!=dest){
			source = copyGraph.getNode(src);
			SaveTheWay.add(source);
			double weight = Double.MAX_VALUE;
			Iterator<edge_data> iteEd = copyGraph.getE(src).iterator();
			while (iteEd.hasNext()){
				edge_data tempEdge = iteEd.next();
				node_data tempNode = this.getGraph().getNode(tempEdge.getDest());
				if(source.getWeight()+tempEdge.getWeight()< weight && source.getWeight()-tempEdge.getWeight()==tempNode.getWeight())
				{
					weight = source.getWeight()+tempEdge.getWeight();
					src = tempEdge.getDest();
				}
			}

		}
		source = copyGraph.getNode(dest);
		SaveTheWay.add(source);
		return SaveTheWay;
	}

	/**
	 * function that change the direction on the edge
	 * @param copy
	 * @return
	 */
	private graph changeDir(graph copy) {
		Graph_Algo addCopy = new Graph_Algo();
		addCopy.init(copy);
		graph CopyToCopy = addCopy.copy();
		Iterator<node_data> iter = copy.getV().iterator();
		while (iter.hasNext()){
			node_data tempOne = iter.next();
			if(copy.getE(tempOne.getKey())!=null) {
				Iterator<edge_data> iterEdge = copy.getE(tempOne.getKey()).iterator();
				while (iterEdge.hasNext()) {
					edge_data tempEdge = iterEdge.next();
					if (CopyToCopy.getEdge(tempEdge.getSrc(), tempEdge.getDest()).getTag() == 0) {
						if (CopyToCopy.getEdge(tempEdge.getDest(), tempEdge.getSrc()) == null) {
							CopyToCopy.connect(tempEdge.getDest(), tempEdge.getSrc(), tempEdge.getWeight());
							CopyToCopy.removeEdge(tempEdge.getSrc(), tempEdge.getDest());
						} else {
							edge_data tEdge = CopyToCopy.getEdge(tempEdge.getDest(), tempEdge.getSrc());
							CopyToCopy.connect(tempEdge.getDest(), tempEdge.getSrc(), tempEdge.getWeight());
							CopyToCopy.connect(tempEdge.getSrc(), tempEdge.getDest(), tEdge.getWeight());
							CopyToCopy.getEdge(tempEdge.getDest(), tempEdge.getSrc()).setTag(1);
						}
					}
				}
			}
		}
		return CopyToCopy;
	}

	/**
	 * Travel sales man!
	 * this function is like shortestPath, but between few nodes.
	 * @param targets
	 * @return
	 */
	@Override
	public List<node_data> TSP(List<Integer> targets) {
		List<node_data> saveThisNodes = new LinkedList<node_data>();
		int theINow = targets.get(0) ;
		int indexToDelete = 0 ;
		int theOnetoThanos = 0 ;
		try {
			while (targets.size() != 1) {
				double min = Double.MAX_VALUE;
				for (int j = 0; j < targets.size(); j++) {
					double ans = shortestPathDist(theINow, targets.get(j));

					if ( targets.get(j) != theINow && min > ans) {

						min = shortestPathDist(theINow, targets.get(j));

						theOnetoThanos = targets.get(j);
						indexToDelete = targets.indexOf(theINow);
					}
				}
				targets.remove(indexToDelete);
				List<node_data> tempArrays = this.shortestPath(theINow, theOnetoThanos);
				AddToTheArrays(saveThisNodes, tempArrays);
				theINow = theOnetoThanos;

			}
			saveThisNodes.add(this.getGraph().getNode(theOnetoThanos));
			ChangeTheTag();
			return saveThisNodes;
		}
		catch (Exception e){
			System.out.println("Not Exist");
			return null;
		}
	}

	/**
	 * function that add nodes to array if the node exist there
	 * @param saveThisNodes
	 * @param tempArrays
	 */
	private void AddToTheArrays(List<node_data> saveThisNodes, List<node_data> tempArrays) {
		Iterator<node_data> iter = tempArrays.iterator();
		while (iter.hasNext())
		{
			saveThisNodes.add(iter.next());
		}
		saveThisNodes.remove(saveThisNodes.get(saveThisNodes.size()-1));
	}

	/**
	 * copy function
	 * @return
	 */
	@Override
	public graph copy() {
		graph p = new DGraph();
		Iterator <node_data> iter = this.getGraph().getV().iterator();
		Iterator <node_data> iter2 = this.getGraph().getV().iterator();
		while(iter.hasNext()){
			NodeData theNewOne = (NodeData) iter.next();
			node_data theCopy = theNewOne.copy();
			p.addNode(theCopy);
		}
		while(iter2.hasNext()){
			node_data theNewOne = iter2.next();
			if(this.getGraph().getE(theNewOne.getKey())!=null) {
				Iterator<edge_data> iterE = this.getGraph().getE(theNewOne.getKey()).iterator();
				while (iterE.hasNext()) {
					EdgeData theNewEdge = (EdgeData) iterE.next();
					edge_data pp = theNewEdge.copy();
					p.connect(pp.getSrc(), pp.getDest(), pp.getWeight());
					p.getEdge(pp.getSrc(), pp.getDest()).setTag(pp.getTag());
				}
			}
		}

		return p;
	}

	/**
	 * function that change the nodes tags to 0
	 */
	public void ChangeTheTag(){
		Iterator<node_data> iter = this.getGraph().getV().iterator();
		while (iter.hasNext()){
			iter.next().setTag(0);
		}
	}

	/**
	 * function that change the edge tags to 0
	 */
	public void ChangeTheTagToEdge(){
		Iterator<node_data> iter = this.getGraph().getV().iterator();
		while (iter.hasNext()){
			node_data n = iter.next();
			if(this.getGraph().getE(n.getKey())!=null) {
				Iterator<edge_data> iter2 = this.getGraph().getE(n.getKey()).iterator();
				while (iter2.hasNext()) {
					iter2.next().setTag(0);
				}
			}
		}
	}


	public static void main(String[] args) {
	}

}