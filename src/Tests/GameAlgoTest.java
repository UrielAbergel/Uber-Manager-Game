package Tests;

import Server.Game_Server;
import Server.game_service;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.FullGameGraph;
import dataStructure.edge_data;
import gameClient.Fruit;
import gameClient.Fruits;
import gameClient.Player;
import gameClient.Players;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import utils.StdDraw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class GameAlgoTest {

    @Test
    public void checkWhereTheFruit() throws JSONException {

        StdDraw.theMain.fullGame.NewGAME(23,true);
        DGraph r = new DGraph();
        r.init(StdDraw.theMain.fullGame.getGame().getGraph());
        StdDraw.theMain.fullGame.setGraphM(r);
        StdDraw.theMain.update();
        List<String> fruitlist = new LinkedList<>();
        fruitlist = StdDraw.theMain.fullGame.getGame().getFruits();
        ArrayList<Fruits> tempArr = new ArrayList<>();
        for (String s : fruitlist) {
            Fruit tempFru = new Fruit(s,StdDraw.theMain.fullGame.getGame().timeToEnd());
            tempFru.setTag(0);
            tempArr.add(tempFru);
        }
        StdDraw.theMain.fullGame.setFruitList(tempArr);
        ArrayList<Fruits> fruList = StdDraw.theMain.fullGame.getF();
        System.out.println(fruList.size());
        edge_data test1 = null;
        for(Fruits fru: fruList)
        {
            test1 = StdDraw.theMain.fullGame.getTheGameAlgo().checkWhereTheFruit(fru);
            break;
        }
        assertEquals(test1.getSrc(),40);
        assertEquals(test1.getDest(),39);
        edge_data test2 = StdDraw.theMain.fullGame.getTheGameAlgo().checkWhereTheFruit(fruList.get(1));
        assertEquals(test2.getSrc(),32);
        assertEquals(test2.getDest(),21);
    }

    @Test
    public void findTheNearestBanana() throws JSONException {
        StdDraw.theMain.fullGame.NewGAME(23,true);
        DGraph r = new DGraph();
        r.init(StdDraw.theMain.fullGame.getGame().getGraph());
        StdDraw.theMain.fullGame.setGraphM(r);
        StdDraw.theMain.update();
        List<String> fruitlist = new LinkedList<>();
        fruitlist = StdDraw.theMain.fullGame.getGame().getFruits();
        ArrayList<Fruits> tempArr = new ArrayList<>();
        for (String s : fruitlist) {
            Fruit tempFru = new Fruit(s,StdDraw.theMain.fullGame.getGame().timeToEnd());
            tempFru.setTag(0);
            tempArr.add(tempFru);
        }
        //======================================================
        ArrayList<Players> tempArr2 = new ArrayList<>();
        String robots = StdDraw.theMain.fullGame.getGame().toString();

        JSONObject json = new JSONObject(robots);
        JSONObject newBobot = json.getJSONObject("GameServer");
        int size = newBobot.getInt("robots");
        int NodesSize = StdDraw.theMain.fullGame.getGraphM().nodeSize();
        if(NodesSize != 0) {
            ArrayList<Integer> Alist = new ArrayList<>();
            Alist.add(0);
            Alist.add((Integer) NodesSize / 2);
            Alist.add((NodesSize - 6));
            if (StdDraw.theMain.fullGame.getAUTO()) {
                for (int i = 0; i < size; i++) {
                    StdDraw.theMain.fullGame.getGame().addRobot(Alist.get(i));
                    Player tempPla = new Player(StdDraw.theMain.fullGame.getGame().getRobots().get(i));
                    tempArr2.add(tempPla);
                }
                StdDraw.theMain.fullGame.setPlayersList(tempArr2);
            }
        }
        //===========================================
        StdDraw.theMain.fullGame.setFruitList(tempArr);
        List<String> playerList = new LinkedList<>();
        List<String> qq = StdDraw.theMain.fullGame.getGame().move();
        if (StdDraw.theMain.fullGame.getGame().getRobots() == null) return;
        playerList = StdDraw.theMain.fullGame.getGame().getRobots();
        ArrayList<Players> tempArr1 = new ArrayList<>();
        for (String s : playerList) {
            Player tempPla = new Player(s);
            tempArr1.add(tempPla);
        }
        StdDraw.theMain.fullGame.setPlayersList(tempArr1);
        ArrayList<Fruits> fruList = StdDraw.theMain.fullGame.getF();
        ArrayList<Players> plaList = StdDraw.theMain.fullGame.getP();
        String test1 = StdDraw.theMain.fullGame.getTheGameAlgo().findTheNearestBanana(plaList.get(0));
        String test2 = StdDraw.theMain.fullGame.getTheGameAlgo().findTheNearestBanana(plaList.get(1));
        String test3 = StdDraw.theMain.fullGame.getTheGameAlgo().findTheNearestBanana(plaList.get(2));

        assertEquals(test1,"12.0,3.0" , test1);
        assertEquals(test1,"21.0,32.0" , test2);
        assertEquals(test1,"40.0,39.0" , test3);


    }

    @Test
    public void returnTheNextID() throws JSONException {
        StdDraw.theMain.fullGame.NewGAME(23,true);
        DGraph r = new DGraph();
        r.init(StdDraw.theMain.fullGame.getGame().getGraph());
        StdDraw.theMain.fullGame.setGraphM(r);
        StdDraw.theMain.update();
        List<String> fruitlist = new LinkedList<>();
        fruitlist = StdDraw.theMain.fullGame.getGame().getFruits();
        ArrayList<Fruits> tempArr = new ArrayList<>();
        for (String s : fruitlist) {
            Fruit tempFru = new Fruit(s,StdDraw.theMain.fullGame.getGame().timeToEnd());
            tempFru.setTag(0);
            tempArr.add(tempFru);
        }
        //======================================================
        ArrayList<Players> tempArr2 = new ArrayList<>();
        String robots = StdDraw.theMain.fullGame.getGame().toString();

        JSONObject json = new JSONObject(robots);
        JSONObject newBobot = json.getJSONObject("GameServer");
        int size = newBobot.getInt("robots");
        int NodesSize = StdDraw.theMain.fullGame.getGraphM().nodeSize();
        if(NodesSize != 0) {
            ArrayList<Integer> Alist = new ArrayList<>();
            Alist.add(0);
            Alist.add((Integer) NodesSize / 2);
            Alist.add((NodesSize - 6));
            if (StdDraw.theMain.fullGame.getAUTO()) {
                for (int i = 0; i < size; i++) {
                    StdDraw.theMain.fullGame.getGame().addRobot(Alist.get(i));
                    Player tempPla = new Player(StdDraw.theMain.fullGame.getGame().getRobots().get(i));
                    tempArr2.add(tempPla);
                }
                StdDraw.theMain.fullGame.setPlayersList(tempArr2);
            }
        }
        //===========================================
        StdDraw.theMain.fullGame.setFruitList(tempArr);
        List<String> playerList = new LinkedList<>();
        List<String> qq = StdDraw.theMain.fullGame.getGame().move();
        if (StdDraw.theMain.fullGame.getGame().getRobots() == null) return;
        playerList = StdDraw.theMain.fullGame.getGame().getRobots();
        ArrayList<Players> tempArr1 = new ArrayList<>();
        for (String s : playerList) {
            Player tempPla = new Player(s);
            tempArr1.add(tempPla);
        }
        StdDraw.theMain.fullGame.setPlayersList(tempArr1);
        ArrayList<Fruits> fruList = StdDraw.theMain.fullGame.getF();
        ArrayList<Players> plaList = StdDraw.theMain.fullGame.getP();
        int test1 = StdDraw.theMain.fullGame.getTheGameAlgo().ReturnTheNextID(plaList.get(0));

        int test2 = StdDraw.theMain.fullGame.getTheGameAlgo().ReturnTheNextID(plaList.get(1));

        int test3 = StdDraw.theMain.fullGame.getTheGameAlgo().ReturnTheNextID(plaList.get(2));

        assertEquals(test1,2);
        assertEquals(test2,31);
        assertEquals(test3,41);



    }


    @Test
    public void NavigateAUTO() throws JSONException, InterruptedException {
        StdDraw.theMain.fullGame.NewGAME(23,true);
        DGraph r = new DGraph();
        r.init(StdDraw.theMain.fullGame.getGame().getGraph());
        StdDraw.theMain.fullGame.setGraphM(r);
        StdDraw.theMain.update();
        List<String> fruitlist = new LinkedList<>();
        fruitlist = StdDraw.theMain.fullGame.getGame().getFruits();
        ArrayList<Fruits> tempArr = new ArrayList<>();
        for (String s : fruitlist) {
            Fruit tempFru = new Fruit(s,StdDraw.theMain.fullGame.getGame().timeToEnd());
            tempFru.setTag(0);
            tempArr.add(tempFru);
        }
        //======================================================
        ArrayList<Players> tempArr2 = new ArrayList<>();
        String robots = StdDraw.theMain.fullGame.getGame().toString();

        JSONObject json = new JSONObject(robots);
        JSONObject newBobot = json.getJSONObject("GameServer");
        int size = newBobot.getInt("robots");
        int NodesSize = StdDraw.theMain.fullGame.getGraphM().nodeSize();
        if(NodesSize != 0) {
            ArrayList<Integer> Alist = new ArrayList<>();
            Alist.add(0);
            Alist.add((Integer) NodesSize / 2);
            Alist.add((NodesSize - 6));
            if (StdDraw.theMain.fullGame.getAUTO()) {
                for (int i = 0; i < size; i++) {
                    StdDraw.theMain.fullGame.getGame().addRobot(Alist.get(i));
                    Player tempPla = new Player(StdDraw.theMain.fullGame.getGame().getRobots().get(i));
                    tempArr2.add(tempPla);
                }
                StdDraw.theMain.fullGame.setPlayersList(tempArr2);
            }
        }
        //===========================================
        StdDraw.theMain.fullGame.setFruitList(tempArr);
        List<String> playerList = new LinkedList<>();
        List<String> qq = StdDraw.theMain.fullGame.getGame().move();
        if (StdDraw.theMain.fullGame.getGame().getRobots() == null) return;
        playerList = StdDraw.theMain.fullGame.getGame().getRobots();
        ArrayList<Players> tempArr1 = new ArrayList<>();
        for (String s : playerList) {
            Player tempPla = new Player(s);
            tempArr1.add(tempPla);
        }
        StdDraw.theMain.fullGame.setPlayersList(tempArr1);
        ArrayList<Fruits> fruList = StdDraw.theMain.fullGame.getF();
        ArrayList<Players> plaList = StdDraw.theMain.fullGame.getP();
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            StdDraw.theMain.fullGame.getTheGameAlgo().NavigateAUTO(plaList.get(i));

        }
        flag = true;
        assertEquals(true,flag);
    }

}