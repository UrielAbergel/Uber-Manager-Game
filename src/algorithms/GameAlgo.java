package algorithms;


import dataStructure.*;
import gameClient.Fruits;
import gameClient.Players;
import utils.Point3D;
import utils.StdDraw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameAlgo {


    private final double  EPS = 0.000000000000001;

    /**
     * function that get fruit the return the edge the fruit leaning on
     * @param p
     * @return edge
     */
    public  edge_data checkWhereTheFruit(Fruits p)
    {
        node_data dest  = new NodeData(0,0,0);
        node_data src = new NodeData(0,0,0);
        edge_data ans = new EdgeData(0,0,0);
        Point3D theLocOfTHEFRUIT = p.getLocation();
        Iterator<node_data> iterV =  StdDraw.theMain.fullGame.getGraphM().getV().iterator();
        while(iterV.hasNext())
        {

            Iterator<edge_data> iterE = StdDraw.theMain.fullGame.getGraphM().getE(iterV.next().getKey()).iterator();
            while(iterE.hasNext())
            {
                edge_data temp = iterE.next();
                src = StdDraw.theMain.fullGame.getGraphM().getNode(temp.getSrc());
                dest = StdDraw.theMain.fullGame.getGraphM().getNode(temp.getDest());
                double disSD = returnDis(dest.getLocation().x(),src.getLocation().x(),dest.getLocation().y(),src.getLocation().y());
                double disSF = returnDis(p.getLocation().x(),src.getLocation().x(),p.getLocation().y(),src.getLocation().y());
                double disDF = returnDis(p.getLocation().x(),dest.getLocation().x(),p.getLocation().y(),dest.getLocation().y());
                if(((disDF+disSF)-disSD)<=EPS) {ans =temp ;}
            }
        }
        return ans ;
    }

    /**
     * return distance between two nodes
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    private  double returnDis(double x1, double x2, double y1, double y2)
    {
        double x = Math.pow((x2-x1),2);
        double y = Math.pow((y2-y1),2);
        return Math.sqrt(x+y);
    }
    static int counter = 0;
    /**
     * function that get player and return the nearest fruit
     * @param p
     * @return fruit
     */
    public static int c= 0 ;
    public String findTheNearestBanana(Players p )
    {
        Graph_Algo newAlgo = new Graph_Algo();
        StdDraw.theMain.fullGame.setAlgo(newAlgo);
        StdDraw.theMain.fullGame.getAlgo().init((StdDraw.theMain.fullGame.getGraphM()));
        ArrayList<Fruits> FruList = StdDraw.theMain.fullGame.getF();
        double min = Double.MAX_VALUE;
        double goToDest = -1 ;
        double NextStep = -1 ;
        boolean t = false ;
        for(Fruits f : FruList)
        {

            if(f.getTag()!=1) {
                t=true;
                c++;
                if (f.getType() == -1) {
                    int dest = checkWhereTheFruit(f).getSrc();
                    int Next = checkWhereTheFruit(f).getDest();
                    if (StdDraw.theMain.fullGame.getAlgo().shortestPathDist(p.getSrc(), dest) < min) {
                        min = StdDraw.theMain.fullGame.getAlgo().shortestPathDist(p.getSrc(), dest);
                        goToDest = dest;
                        NextStep = Next;
                        f.setTag(1);

                    }
                }
                if (f.getType() == 1) {
                    int dest = checkWhereTheFruit(f).getDest();
                    int Next = checkWhereTheFruit(f).getSrc();
                    if (StdDraw.theMain.fullGame.getAlgo().shortestPathDist(p.getSrc(), dest) < min) {
                        min = StdDraw.theMain.fullGame.getAlgo().shortestPathDist(p.getSrc(), dest);
                        goToDest = dest;
                        NextStep = Next;
                        f.setTag(1);

                    }
                }
            }
            else{
                f.setTag(0);
            }
            if(!AllBananTag()) resetFruitTag();

        }


        return "" + goToDest + "," +NextStep ;
    }
    private double x = 1/3;
    private boolean AllBananTag() {
        ArrayList<Fruits> FruList = StdDraw.theMain.fullGame.getF();
        for (Fruits fru : FruList)
        {
            if(fru.getTag() == 0 && x%2 == 0) return true;
            x = x + 1/3;
        }
        return false;
    }

    private void resetFruitTag() {
        ArrayList<Fruits> fList = StdDraw.theMain.fullGame.getF();
        for (Fruits f : fList){

            f.setTag(0);

        }
    }


    /**
     * function that return the nextID node dest.
     * @param p
     * @return
     */
    public int ReturnTheNextID(Players p )
    {
        Graph_Algo newAlgo = new Graph_Algo();
        StdDraw.theMain.fullGame.setAlgo(newAlgo);
        StdDraw.theMain.fullGame.getAlgo().init((StdDraw.theMain.fullGame.getGraphM()));
        ArrayList<Integer> TheAns = new ArrayList<>();
        String temp = findTheNearestBanana(p);
        String[] tempARR = temp.split(",");
        List<node_data> TheNodesList = StdDraw.theMain.fullGame.getAlgo().shortestPath(p.getSrc(), (int) Double.parseDouble(tempARR[1]));
        for(node_data node : TheNodesList)
        {
            TheAns.add(node.getKey());
        }
        TheAns.add((int) Double.parseDouble(tempARR[0]));
        if(TheAns.size()==1){return TheAns.get(0);}
        return TheAns.get(1);
    }

    /**
     * move the player to next dest. work only for AUTO game
     * @param p
     */
    public void NavigateAUTO(Players p ) {
        int theWay = ReturnTheNextID(p );
        StdDraw.theMain.fullGame.getGame().chooseNextEdge(p.getKey(),theWay);
    }

}