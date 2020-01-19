package Tests;

import dataStructure.DGraph;
import gameClient.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import utils.StdDraw;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class KML_LoggerTest {


    // need to hold 30 sec for the test to create and check
    @Test
    public void createOBJforKML() throws JSONException {
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
        StdDraw.theMain.fullGame.getGame().startGame();
        KML_Logger logger_kml = new KML_Logger();
        boolean tryIsgood = false;
                try {
                    logger_kml.CreateOBJforKML();
                    tryIsgood= true;

                } catch (ParseException | InterruptedException ex) {
                    ex.printStackTrace();
                }

                assertEquals(true,tryIsgood);




    }
}