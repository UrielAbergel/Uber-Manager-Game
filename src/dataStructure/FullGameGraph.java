package dataStructure;

import Server.*;
import algorithms.*;
import gameClient.*;
import gameClient.Fruit;
import netscape.javascript.JSObject;
import utils.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FullGameGraph {
    private graph graphM = new DGraph();
    private graph_algorithms algo = new Graph_Algo();
    private ArrayList<Players> PlayersList = new ArrayList<>();
    private ArrayList<Fruits> FruitList = new ArrayList<>();
    private game_service game ;

    public void NewGAME(int sen){
        this.game = Game_Server.getServer(sen);
    }

    public FullGameGraph(){}

    public FullGameGraph(graph g , ArrayList<Players> p , ArrayList<Fruits> f, graph_algorithms a)
    {
       init(g,p,f,a);

    }
    public void init(graph g, ArrayList<Players> p, ArrayList<Fruits> f,graph_algorithms algo) {
        this.graphM = g ;
        this.PlayersList = p ;
        this.FruitList = f ;
        this.algo = algo ;

    }
    public game_service getGame(){
        return this.game;
    }
    public void setGame(game_service g){
        this.game = g;
    }
    public ArrayList<Players> getP(){
        return this.PlayersList;
    }
    public ArrayList<Fruits> getF(){
        return this.FruitList;
    }

    public graph getGraphM(){
        return this.graphM;
    }
    public void setGraphM(graph g){
        this.graphM = g;
    }

    public void setAlgo(graph_algorithms g){
        this.algo = g ;
    }

    public graph_algorithms getAlgo(){
        return this.algo;
    }

    public int findIDplayer(int id){
        int find = 0 ;
        for (int i = 0; i < PlayersList.size(); i++) {
            if(PlayersList.get(i).getKey() == id)
            {
                find = i ;
            }
        }
        return find;
    }


    public void addPlayer(Player p) {
        PlayersList.add(p);
    }
    public void addFruits(Fruits f) {
        FruitList.add(f);
    }

    public void printPlayer(){
        for(Players newPlayer : PlayersList){
            StdDraw.picture(newPlayer.getLocation().x(),newPlayer.getLocation().y(),newPlayer.getPicture(),0.001,0.001);
        }
    }

    public void printFruits(){
        for(Fruits newFruit : FruitList){
            StdDraw.picture(newFruit.getLocation().x(),newFruit.getLocation().y(),newFruit.getPicture(),0.001,0.001);
        }
    }
     public void setPlayersList(ArrayList<Players> p)
     {
         this.PlayersList = p ;
     }

    public void setFruitList(ArrayList<Fruits> f)
    {
        this.FruitList = f ;
    }


}
