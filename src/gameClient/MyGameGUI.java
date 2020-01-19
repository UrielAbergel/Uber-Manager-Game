package gameClient;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Server.Game_Server;
import Server.game_service;
import algorithms.Graph_Algo;
import com.sun.source.doctree.SerialDataTree;
import dataStructure.* ;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import org.json.JSONException;
import org.json.JSONObject;
import utils.*;
import algorithms.*;


/**
 !!!!Comments on Interface!!!!
 */
public class MyGameGUI extends Thread implements game_gui {
    int CurrentMc = 0;
    public KML_Logger kml = new KML_Logger();
    public FullGameGraph fullGame = new FullGameGraph();

    public Range returnTheX() {
        graph current = StdDraw.theMain.fullGame.getGraphM();
        double MaxX = Integer.MIN_VALUE;
        double MinX = Integer.MAX_VALUE;
        Iterator<node_data> iter = current.getV().iterator();
        while (iter.hasNext()) {
            node_data currentNode = iter.next();
            Point3D p = currentNode.getLocation();
            if (p.x() > MaxX) MaxX = p.x();
            if (p.x() < MinX) MinX = p.x();
        }
        Range ans = new Range(MinX, MaxX);
        return ans;
    }

    public Range returnTheY() {
        graph current = StdDraw.theMain.fullGame.getGraphM();
        double MaxY = Integer.MIN_VALUE;
        double MinY = Integer.MAX_VALUE;
        Iterator<node_data> iter = current.getV().iterator();
        while (iter.hasNext()) {
            node_data currentNode = iter.next();
            Point3D p = currentNode.getLocation();
            if (p.y() > MaxY) MaxY = p.y();
            if (p.y() < MinY) MinY = p.y();
        }
        Range ans = new Range(MinY, MaxY);
        return ans;
    }

    public void MainDraw() {
        this.start();
        StdDraw.setCanvasSize(1400, 1000);
        StdDraw.theMain.fullGame = this.fullGame;
        StdDraw.theMain.fullGame.setGraphM(this.fullGame.getGraphM());
        StdDraw.theMain.CurrentMc = this.CurrentMc;
        Range x = returnTheX();
        Range y = returnTheY();
        StdDraw.setCanvasSize(1400, 1000);
        double FixXscale = (x.get_max() - x.get_min()) * 0.2;
        double FixYscale = (y.get_max() - y.get_min()) * 0.2;
        StdDraw.setXscale(-80, 80);
        StdDraw.setYscale(-80, 80);
        StdDraw.picture(0,0,"pic\\open.PNG",160,140);
        StdDraw.createMenuBar();
        StdDraw.theMain.fullGame = this.fullGame;
        StdDraw.enableDoubleBuffering();
    }

    private ArrayList<Integer> MakeListInt(List<node_data> p) {
        ArrayList<Integer> ans = new ArrayList<>();
        Iterator<node_data> iter = p.iterator();
        while (iter.hasNext()) {
            ans.add(iter.next().getKey());
        }
        return ans;
    }


    public void update(List<node_data> p) {
        StdDraw.clear();
        Range x = returnTheX();
        Range y = returnTheY();
        double FixXscale = (x.get_max() - x.get_min()) * 0.2;
        double FixYscale = (y.get_max() - y.get_min()) * 0.3;
        StdDraw.setXscale(x.get_min() - FixXscale, x.get_max() * 1.00002);
        StdDraw.setYscale(y.get_min() - FixYscale, y.get_max() * 1.00006);
        double TheYUp = (y.get_max() - y.get_min()) * 0.02;
        double TheXUp = (x.get_max() - x.get_min()) * 0.02;
        double rightScaleX = ((x.get_max() - x.get_min()) * 0.04);
        double rightScaleY = ((y.get_max() - y.get_min()) * 0.04);
        Iterator<node_data> iterNodes = this.fullGame.getGraphM().getV().iterator();
        StdDraw.picture((x.get_max()+x.get_min())/2,(y.get_max()+y.get_min())/2,"pic\\\u200F\u200Fbackround.PNG",(x.get_max()-x.get_min())*1.6,(y.get_max()-y.get_min())*1.6);
        int grade = ReturnTheGrade();
        if(StdDraw.theMain.fullGame.getCen() > 11)
        {
            StdDraw.picture(x.get_min() - 8 * TheXUp, y.get_max(), "pic\\clock.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.picture(x.get_min() - 3 * TheXUp, y.get_max(), "pic\\value.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.text(x.get_min()- 8 * TheXUp , y.get_max()-3*TheYUp , ""+StdDraw.theMain.fullGame.getGame().timeToEnd()/1000);
            StdDraw.text(x.get_min()- 3 * TheXUp , y.get_max()-3*TheYUp , ""+grade);
        }
        if(StdDraw.theMain.fullGame.getCen() <= 11)
        {
            StdDraw.picture(x.get_min()- 8 * TheXUp , y.get_max()+5.2*TheYUp, "pic\\clock.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.picture(x.get_min()- 3 * TheXUp , y.get_max()+5.2*TheYUp, "pic\\value.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.text(x.get_min()- 8 * TheXUp , y.get_max()+2.5*TheYUp , ""+StdDraw.theMain.fullGame.getGame().timeToEnd()/1000);
            StdDraw.text(x.get_min()- 3 * TheXUp , y.get_max()+2.5*TheYUp , ""+grade);

        }
        while (iterNodes.hasNext()) {
            node_data theCurrent = iterNodes.next();
            StdDraw.picture(theCurrent.getLocation().x(), theCurrent.getLocation().y(), "pic\\light.jfif", rightScaleX , rightScaleY );
            Point3D tempP = theCurrent.getLocation();
            StdDraw.setPenColor(Color.black);
            StdDraw.text(tempP.x(), tempP.y() + TheYUp, "" + theCurrent.getKey());
            if (this.fullGame.getGraphM().getE(theCurrent.getKey()) != null) {
                Iterator<edge_data> iterEdge = this.fullGame.getGraphM().getE(theCurrent.getKey()).iterator();
                while (iterEdge.hasNext()) {
                    edge_data tempEdge = iterEdge.next();
                    node_data src = this.fullGame.getGraphM().getNode(tempEdge.getSrc());
                    Point3D srcP = src.getLocation();
                    node_data dest = this.fullGame.getGraphM().getNode(tempEdge.getDest());
                    Point3D destP = dest.getLocation();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(srcP.x(), srcP.y(), destP.x(), destP.y());
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenColor(Color.BLUE);
                    DecimalFormat df2 = new DecimalFormat("#.#");
                    StdDraw.text((srcP.x() * 0.2 + destP.x() * 0.8), (srcP.y() * 0.2 + destP.y() * 0.8) + TheYUp, df2.format(tempEdge.getWeight()));
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);

                }
            }
        }
        ArrayList<Integer> save = this.MakeListInt(p);
        for (int i = 0; i < save.size() - 1; i++) {
            int src = save.get(i);
            int dest = save.get(i + 1);
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.line(this.fullGame.getGraphM().getNode(src).getLocation().x(), this.fullGame.getGraphM().getNode(src).getLocation().y(), this.fullGame.getGraphM().getNode(dest).getLocation().x(), this.fullGame.getGraphM().getNode(dest).getLocation().y());
            //StdDraw.picture((this.fullGame.getGraphM().getNode(src).getLocation().x() + this.fullGame.getGraphM().getNode(dest).getLocation().x()) / 2, (this.fullGame.getGraphM().getNode(src).getLocation().y() + this.fullGame.getGraphM().getNode(dest).getLocation().y()) / 2, "pic\\1.jfif", rightScaleX * 0.6, rightScaleY * 0.6);
        }
        StdDraw.createMenuBar();
        StdDraw.show();

    }

    public void update() {
        StdDraw.clear();
        Range x = returnTheX();
        Range y = returnTheY();
        double FixXscale = (x.get_max() - x.get_min()) * 0.2;
        double FixYscale = (y.get_max() - y.get_min()) * 0.3;
        StdDraw.setXscale(x.get_min() - FixXscale, x.get_max() * 1.00002);
        StdDraw.setYscale(y.get_min() - FixYscale, y.get_max() * 1.00006);
        double TheYUp = (y.get_max() - y.get_min()) * 0.02;
        double TheXUp = (x.get_max() - x.get_min()) * 0.02;
        double rightScaleX = ((x.get_max() - x.get_min()) * 0.04);
        double rightScaleY = ((y.get_max() - y.get_min()) * 0.04);
        Iterator<node_data> iterNodes = this.fullGame.getGraphM().getV().iterator();
        StdDraw.picture((x.get_max()+x.get_min())/2,(y.get_max()+y.get_min())/2,"pic\\\u200F\u200Fbackround.PNG",(x.get_max()-x.get_min())*1.6,(y.get_max()-y.get_min())*1.6);
        int grade = ReturnTheGrade();
        if(StdDraw.theMain.fullGame.getCen() > 11)
        {
            StdDraw.picture(x.get_min() - 8 * TheXUp, y.get_max(), "pic\\clock.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.picture(x.get_min() - 3 * TheXUp, y.get_max(), "pic\\value.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.text(x.get_min()- 8 * TheXUp , y.get_max()-3*TheYUp , ""+StdDraw.theMain.fullGame.getGame().timeToEnd()/1000);
            StdDraw.text(x.get_min()- 3 * TheXUp , y.get_max()-3*TheYUp , ""+grade);
        }
        if(StdDraw.theMain.fullGame.getCen() <= 11)
        {
            StdDraw.picture(x.get_min()- 8 * TheXUp , y.get_max()+5.2*TheYUp, "pic\\clock.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.picture(x.get_min()- 3 * TheXUp , y.get_max()+5.2*TheYUp, "pic\\value.png", rightScaleX * 2, rightScaleY * 2);
            StdDraw.text(x.get_min()- 8 * TheXUp , y.get_max()+2.5*TheYUp , ""+StdDraw.theMain.fullGame.getGame().timeToEnd()/1000);
            StdDraw.text(x.get_min()- 3 * TheXUp , y.get_max()+2.5*TheYUp , ""+grade);

        }
        while (iterNodes.hasNext()) {
            node_data theCurrent = iterNodes.next();
            StdDraw.picture(theCurrent.getLocation().x(), theCurrent.getLocation().y(), "pic\\light.jfif", rightScaleX , rightScaleY );
            Point3D tempP = theCurrent.getLocation();
            StdDraw.setPenColor(Color.black);
            StdDraw.text(tempP.x(), tempP.y() + TheYUp, "" + theCurrent.getKey());
            if (this.fullGame.getGraphM().getE(theCurrent.getKey()) != null) {
                Iterator<edge_data> iterEdge = this.fullGame.getGraphM().getE(theCurrent.getKey()).iterator();
                while (iterEdge.hasNext()) {
                    edge_data tempEdge = iterEdge.next();
                    node_data src = this.fullGame.getGraphM().getNode(tempEdge.getSrc());
                    Point3D srcP = src.getLocation();
                    node_data dest = this.fullGame.getGraphM().getNode(tempEdge.getDest());
                    Point3D destP = dest.getLocation();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(srcP.x(), srcP.y(), destP.x(), destP.y());
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenColor(Color.BLUE);
                    DecimalFormat df2 = new DecimalFormat("#.#");
                    StdDraw.text((srcP.x() * 0.2 + destP.x() * 0.8), (srcP.y() * 0.2 + destP.y() * 0.8) + TheYUp, df2.format(tempEdge.getWeight()));
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle((srcP.x() * 0.1 + destP.x() * 0.9), (srcP.y() * 0.1 + destP.y() * 0.9), rightScaleX * 0.06);

                }
            }
        }
        if (StdDraw.theMain.fullGame.getGame().isRunning()) {
            for (Players pla : StdDraw.theMain.fullGame.getP()) {
                StdDraw.picture(pla.getLocation().x(), pla.getLocation().y(), pla.getPicture(), rightScaleX*1.4, rightScaleY*1.4);

            }
            for (Fruits fruty : StdDraw.theMain.fullGame.getF()) {
                StdDraw.picture(fruty.getLocation().x(), fruty.getLocation().y(), fruty.getPicture(), rightScaleX*1.4, rightScaleY*1.4);
//                StdDraw.picture(0,0,"pic\\\u200F\u200Fbackround.PNG",160,rightScaleY);
            }
        }
        else if(!StdDraw.theMain.fullGame.getAUTO()){
            for (Players pla : StdDraw.theMain.fullGame.getP()) {
                StdDraw.picture(pla.getLocation().x(), pla.getLocation().y(), pla.getPicture(), rightScaleX*1.4, rightScaleY*1.4);

            }
        }
        StdDraw.createMenuBar();
        StdDraw.show();
    }

    private int ReturnTheGrade() {
        String s = StdDraw.theMain.fullGame.getGame().toString();
        String[] arr = s.split(",");
        s = arr[2].substring(8 , arr[2].length());
        return (Integer.parseInt(s));
    }

    private void movePlayerAUTO()
    {
        ArrayList<Players> PlaList = StdDraw.theMain.fullGame.getP();
        for(Players pla : PlaList)
        {
            StdDraw.theMain.fullGame.getTheGameAlgo().NavigateAUTO(pla);
        }
    }

    private int prevCounter = 0 ;
    private int counter = 0 ;
    @Override
    public void run() {

        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.fullGame.getGraphM().getMC() != CurrentMc) {
                CurrentMc = this.fullGame.getGraphM().getMC();
                update();
            }
            try {
                ArrayList<Players> tempArr = new ArrayList<>();
                String robots = StdDraw.theMain.fullGame.getGame().toString();
                //System.out.println(StdDraw.theMain.fullGame.getGame().toString());
                JSONObject json = new JSONObject(robots);
                JSONObject newBobot = json.getJSONObject("GameServer");
                int size = newBobot.getInt("robots");
                int NodesSize = StdDraw.theMain.fullGame.getGraphM().nodeSize();
                if(NodesSize != 0) {
                    ArrayList<Integer> Alist = new ArrayList<>();
                    Alist.add(0);
                    Alist.add((Integer) NodesSize / 2);
                    Alist.add((NodesSize - 6));
                    //System.out.println(Alist);


                    if (StdDraw.theMain.fullGame.getAUTO()) {
                        for (int i = 0; i < size; i++) {
                            System.out.println(StdDraw.theMain.fullGame.getGame().addRobot(Alist.get(i)));
                            System.out.println(Alist.get(i));
                            Player tempPla = new Player(StdDraw.theMain.fullGame.getGame().getRobots().get(i));
                            tempArr.add(tempPla);
                        }
                        StdDraw.theMain.fullGame.setPlayersList(tempArr);
                    }
                }
               // System.out.println(StdDraw.theMain.fullGame.getGame().getRobots());
                while (StdDraw.theMain.fullGame.getGame().isRunning()) {
                    updateRobots();
                    updateFruits();
                    if(StdDraw.theMain.fullGame.getAUTO())
                    {
                        movePlayerAUTO();
                    }
                    resetEdge();
                    update();
                    //  StdDraw.show();
                    counter++;
                  //  System.out.println(StdDraw.theMain.fullGame.getGame().timeToEnd()/1000);
                }
              if(!StdDraw.theMain.fullGame.getGame().isRunning()){
                  if(counter>prevCounter){
                      prevCounter = counter;
                      //counter++;
                 //     System.out.println(StdDraw.theMain.fullGame.getGame().toString());
                  }

              }
            } catch (Exception e) {

            }
        }
    }

    private void resetEdge() {
        Iterator<node_data> iter = StdDraw.theMain.fullGame.getGraphM().getV().iterator();
        while (iter.hasNext()){
            node_data n = iter.next();
            if(StdDraw.theMain.fullGame.getGraphM().getE(n.getKey())!=null) {
                Iterator<edge_data> iter2 = StdDraw.theMain.fullGame.getGraphM().getE(n.getKey()).iterator();
                while (iter2.hasNext()) {
                    iter2.next().setTag(0);
                }
            }
        }
    }

    private void updateFruits() throws JSONException {
        List<String> fruitlist = new LinkedList<>();
        fruitlist = this.fullGame.getGame().getFruits();
        ArrayList<Fruits> tempArr = new ArrayList<>();
        for (String s : fruitlist) {
            Fruit tempFru = new Fruit(s,StdDraw.theMain.fullGame.getGame().timeToEnd());
            tempArr.add(tempFru);
        }
        this.fullGame.setFruitList(tempArr);

    }

    private void updateRobots() throws JSONException {
        List<String> playerList = new LinkedList<>();
        List<String> qq = StdDraw.theMain.fullGame.getGame().move();
        if (this.fullGame.getGame().getRobots() == null) return;
        playerList = StdDraw.theMain.fullGame.getGame().move();
        ArrayList<Players> tempArr = new ArrayList<>();
        for (String s : playerList) {
            Player tempPla = new Player(s);
            tempArr.add(tempPla);
        }
        this.fullGame.setPlayersList(tempArr);

    }

    public void init(FullGameGraph g) {
        this.fullGame = g;
        StdDraw.theMain.fullGame = g;
    }

    public  void createKML() throws JSONException, ParseException, InterruptedException {
        this.kml.CreateOBJforKML();

    }


    public static void main(String[] args) throws JSONException, ParseException {

//        game_service newgame = Game_Server.getServer(1);
//        newgame.startGame();
//        System.out.println(newgame.isRunning());
//        DGraph EEEE = new DGraph();
//
//        EEEE.init(newgame.getGraph());
//        ArrayList<Players> players = new ArrayList<>();
//        ArrayList<Fruits> banana = new ArrayList<>();
//        Graph_Algo p = new Graph_Algo();
//        p.init(EEEE);

        //  ===================================================test without stdraw============================================
//        newgame.startGame();
//        newgame.addRobot(0);
//        for(String s : newgame.getRobots()){
//            players.add(new Player(s));
//        }
//        for(String s : newgame.getFruits()){
//            banana.add(new Fruit(s));
//        }
//        FullGameGraph fullgame = new FullGameGraph();
//        fullgame.init(EEEE,players,banana,p);
//
//        StdDraw.theMain.fullGame = fullgame;
//        fullgame.getAlgo().shortestPath(8,4);
//        String temp = "new EdgeData(0,0,0)";
//           List<Players> fruList = StdDraw.theMain.fullGame.getP();
//           newgame.startGame();
//        for(Players fru : players) {
//
//            fullgame.getTheGameAlgo().NavigateAUTO(fru);
//            System.out.println(temp);
//        }
        //fullgame.setGame(newgame);

//        fullgame.NewGAME(1);
        //fullgame.getGame().isRunning();
//        List<String> robotyala = new LinkedList<>();

        // robotyala = newgame.getRobots();

        //===========================================end of the test without std==========================================
        FullGameGraph fullgame = new FullGameGraph();
        MyGameGUI game = new MyGameGUI();
       game.init(fullgame);
        game.MainDraw();
    }
}
