package dataStructure;

import gameClient.*;

import java.util.ArrayList;

public class FullGameGraph {
    graph graphM = new DGraph();
    ArrayList<Players> PlayersList = new ArrayList<>();
    ArrayList<Fruits> FruitList = new ArrayList<>();

    public FullGameGraph(){}

    public FullGameGraph(graph g , ArrayList<Players> p , ArrayList<Fruits> f)
    {
       init(g,p,f);

    }
    private void init(graph g, ArrayList<Players> p, ArrayList<Fruits> f) {
        this.graphM = g ;
        this.PlayersList = p ;
        this.FruitList = f ;
    }

    public ArrayList<Players> getP(){
        return this.PlayersList;
    }
    public ArrayList<Fruits> getF(){
        return this.FruitList;
    }
}
