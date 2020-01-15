package Tests;

import algorithms.GameAlgo;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.FullGameGraph;
import dataStructure.graph;
import gameClient.Fruit;
import gameClient.Fruits;
import gameClient.Player;
import gameClient.Players;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FullGameGraphTest {


    @Test
    public void getP() {

        FullGameGraph g = new FullGameGraph();
        ArrayList<Players> Plist = new ArrayList<>();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setPlayersList(Plist);
        assertEquals(Plist,g.getP());

    }

    @Test
    public void getF() {
        FullGameGraph g = new FullGameGraph();
        ArrayList<Fruits> Plist = new ArrayList<>();
        Fruit p1 = new Fruit();
        Fruit p2 = new Fruit();
        Fruit p3 = new Fruit();
        Fruit p4 = new Fruit();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setFruitList(Plist);
        assertEquals(Plist,g.getF());
    }

    @Test
    public void getGraphM() {
        FullGameGraph g = new FullGameGraph();
        graph gf = new DGraph();
        g.setGraphM(gf);
        assertEquals(g.getGraphM(),gf);
        graph gr = new DGraph();
        g.setGraphM(gr);
        assertEquals(g.getGraphM(),gr);
    }

    @Test
    public void setGraphM() {
        FullGameGraph g = new FullGameGraph();
        graph gf = new DGraph();
        g.setGraphM(gf);
        assertEquals(g.getGraphM(),gf);
        graph gr = new DGraph();
        g.setGraphM(gr);
        assertEquals(g.getGraphM(),gr);
    }

    @Test
    public void getAlgo() {
        FullGameGraph g = new FullGameGraph();
        Graph_Algo GA = new Graph_Algo();
        g.setAlgo(GA);
        assertEquals(GA,g.getAlgo());
        Graph_Algo BG = new Graph_Algo();
        g.setAlgo(BG);
        assertEquals(BG,g.getAlgo());
    }

    @Test
    public void addPlayer() {
        FullGameGraph g = new FullGameGraph();
        ArrayList<Players> Plist = new ArrayList<>();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setPlayersList(Plist);
        assertEquals(Plist.get(0),p1);
        assertEquals(Plist.get(1),p2);
        assertEquals(Plist.get(2),p3);
        assertEquals(Plist.get(3),p4);

    }

    @Test
    public void addFruits() {
        FullGameGraph g = new FullGameGraph();
        ArrayList<Fruits> Plist = new ArrayList<>();
        Fruit p1 = new Fruit();
        Fruit p2 = new Fruit();
        Fruit p3 = new Fruit();
        Fruit p4 = new Fruit();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setFruitList(Plist);
        assertEquals(Plist.get(0),p1);
        assertEquals(Plist.get(1),p2);
        assertEquals(Plist.get(2),p3);
        assertEquals(Plist.get(3),p4);

    }

    @Test
    public void setPlayersList() {
        FullGameGraph g = new FullGameGraph();
        ArrayList<Players> Plist = new ArrayList<>();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setPlayersList(Plist);
        assertEquals(g.getP(),Plist);
    }

    @Test
    public void setFruitList() {
        FullGameGraph g = new FullGameGraph();
        ArrayList<Fruits> Plist = new ArrayList<>();
        Fruit p1 = new Fruit();
        Fruit p2 = new Fruit();
        Fruit p3 = new Fruit();
        Fruit p4 = new Fruit();
        Plist.add(p1);
        Plist.add(p2);
        Plist.add(p3);
        Plist.add(p4);
        g.setFruitList(Plist);
        assertEquals(g.getF(),Plist);
    }

    @Test
    public void getTheGameAlgo() {
        FullGameGraph g = new FullGameGraph();
        GameAlgo GA = new GameAlgo();
        g.setTheGameAlgo(GA);
        assertEquals(GA,g.getTheGameAlgo());
        GameAlgo GC = new GameAlgo();
        g.setTheGameAlgo(GC);
        assertEquals(GC,g.getTheGameAlgo());
    }

    @Test
    public void setTheGameAlgo() {
        FullGameGraph g = new FullGameGraph();
        GameAlgo GA = new GameAlgo();
        g.setTheGameAlgo(GA);
        assertEquals(GA,g.getTheGameAlgo());
        GameAlgo GC = new GameAlgo();
        g.setTheGameAlgo(GC);
        assertEquals(GC,g.getTheGameAlgo());
    }
}