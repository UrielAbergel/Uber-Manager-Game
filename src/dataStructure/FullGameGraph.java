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

public class FullGameGraph implements full_graph_game{
    private graph graphM = new DGraph();
    private Graph_Algo algo = new Graph_Algo();
    private ArrayList<Players> PlayersList = new ArrayList<>();
    private ArrayList<Fruits> FruitList = new ArrayList<>();
    private game_service game ;
    private int currentCen = -1 ;
    private GameAlgo gameAlgo = new GameAlgo();
    private boolean isAUTO = false ;

    public void NewGAME(int sen , boolean isAUTO){
        this.game = Game_Server.getServer(sen);
        this.currentCen = sen;
        this.isAUTO =isAUTO;
    }

    public FullGameGraph(){}

    public FullGameGraph(graph g , ArrayList<Players> p , ArrayList<Fruits> f, Graph_Algo a)
    {
       init(g,p,f,a);

    }
    public void init(graph g, ArrayList<Players> p, ArrayList<Fruits> f,Graph_Algo algo) {
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

    public void setAlgo(Graph_Algo g)
    {
        g.init(this.graphM);
        this.algo = g ;
    }
    public boolean getAUTO()
    {
        return this.isAUTO;
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

    public void setCen(int c){
        this.currentCen = c;
    }
    public int getCen(){
        return this.currentCen;
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

    public GameAlgo getTheGameAlgo(){
        return this.gameAlgo;
    }

    public void setTheGameAlgo(GameAlgo g){
        this.gameAlgo = g;
    }

}
