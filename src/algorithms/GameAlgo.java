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

    public static edge_data checkTheNearestFruits(Fruits p)
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
                 if(((disDF+disSF)-disSD)<=0.000000000000001) {ans =temp ;}
             }
         }
         return ans ;
    }

    public static double returnDis(double x1, double x2, double y1, double y2)
    {
        double x = Math.pow((x2-x1),2);
        double y = Math.pow((y2-y1),2);
        return Math.sqrt(x+y);
    }


}
