package gameClient;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import algorithms.Graph_Algo;
import dataStructure.* ;
import utils.*;

public class MyGameGUI extends Thread {
    int CurrentMc = 0;
    public FullGameGraph theMain= new FullGameGraph();
    public MyGameGUI(){
        StdDraw.theMain = this;

        this.start();
    }
    public Range returnTheX(){
        graph current = StdDraw.theMain.AlgoGraph.getGraph();
        double MaxX = Integer.MIN_VALUE;
        double MinX = Integer.MAX_VALUE;
        Iterator<node_data> iter =current.getV().iterator();
        while (iter.hasNext()){
            node_data currentNode = iter.next();
            Point3D p = currentNode.getLocation();
            if(p.x() > MaxX) MaxX =  p.x();
            if(p.x() < MinX) MinX =  p.x();
        }
        Range ans = new Range(MinX , MaxX);
        return ans;
    }
    public Range returnTheY(){
        graph current = StdDraw.theMain.AlgoGraph.getGraph();
        double MaxY = Integer.MIN_VALUE;
        double MinY = Integer.MAX_VALUE;
        Iterator<node_data> iter =current.getV().iterator();
        while (iter.hasNext()){
            node_data currentNode = iter.next();
            Point3D p = currentNode.getLocation();
            if(p.y() > MaxY) MaxY =  p.y();
            if(p.y() < MinY) MinY =  p.y();
        }
        Range ans = new Range(MinY , MaxY);
        return ans;
    }
    public void MainDraw(){
        Range x = returnTheX();
        Range y = returnTheY();
        StdDraw.setCanvasSize(700,700);
        double FixXscale = (x.get_max()-x.get_min())*0.2;
        double FixYscale = (y.get_max()-y.get_min())*0.2;
        StdDraw.setXscale(x.get_min()-FixXscale,x.get_max()*1.2);
        StdDraw.setYscale(y.get_min()-FixYscale,y.get_max()*1.2);
        double TheYUp = (y.get_max()-y.get_min())*0.03;
        double rightScaleX = ((x.get_max()-x.get_min())*0.04);
        double rightScaleY =  ((y.get_max()-y.get_min())*0.04);
        Iterator<node_data> iterNodes = this.AlgoGraph.getGraph().getV().iterator();
        while (iterNodes.hasNext()) {
            node_data theCurrent = iterNodes.next();
            StdDraw.picture(theCurrent.getLocation().x(),theCurrent.getLocation().y(),"pic\\light.jfif",rightScaleX,rightScaleY);
            Point3D tempP = theCurrent.getLocation();
            StdDraw.setPenColor(Color.black);
            StdDraw.text(tempP.x(), tempP.y()+TheYUp, "" + theCurrent.getKey());
            if (this.AlgoGraph.getGraph().getE(theCurrent.getKey()) != null) {
                Iterator<edge_data> iterEdge = this.AlgoGraph.getGraph().getE(theCurrent.getKey()).iterator();
                while (iterEdge.hasNext()) {
                    edge_data tempEdge = iterEdge.next();
                    node_data src = this.AlgoGraph.getGraph().getNode(tempEdge.getSrc());
                    Point3D srcP = src.getLocation();
                    node_data dest = this.AlgoGraph.getGraph().getNode(tempEdge.getDest());
                    Point3D destP = dest.getLocation();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(srcP.x(), srcP.y(), destP.x(), destP.y());
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenColor(Color.BLUE);
                    StdDraw.text((srcP.x()*0.2 +destP.x()*0.8), (srcP.y()*0.2+destP.y()*0.8)+TheYUp, "" + tempEdge.getWeight());
                    StdDraw.setPenColor(Color.RED);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.25);
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.2);
                }
            }
        }
        StdDraw.createMenuBar();
        StdDraw.theMain.AlgoGraph = this.AlgoGraph;
    }
    public ArrayList<Integer> MakeListInt(List<node_data> p ){
        ArrayList<Integer> ans = new ArrayList<>();
        Iterator<node_data> iter = p.iterator();
        while (iter.hasNext()){
            ans.add(iter.next().getKey());
        }
        return  ans;
    }
    public void update(List<node_data> p){
        StdDraw.clear();
        Range x = returnTheX();
        Range y = returnTheY();
        StdDraw.setCanvasSize(700,700);
        double FixXscale = (x.get_max()-x.get_min())*0.2;
        double FixYscale = (y.get_max()-y.get_min())*0.2;
        StdDraw.setXscale(x.get_min()-FixXscale,x.get_max()*1.2);
        StdDraw.setYscale(y.get_min()-FixYscale,y.get_max()*1.2);
        double TheYUp = (y.get_max()-y.get_min())*0.03;
        double rightScaleX = ((x.get_max()-x.get_min())*0.04);
        double rightScaleY =  ((y.get_max()-y.get_min())*0.04);
        Iterator<node_data> iterNodes = this.AlgoGraph.getGraph().getV().iterator();
        while (iterNodes.hasNext()) {
            node_data theCurrent = iterNodes.next();
            StdDraw.picture(theCurrent.getLocation().x(),theCurrent.getLocation().y(),"pic\\light.jfif",rightScaleX,rightScaleY);
            Point3D tempP = theCurrent.getLocation();
            StdDraw.setPenColor(Color.black);
            StdDraw.text(tempP.x(), tempP.y()+TheYUp, "" + theCurrent.getKey());
            if (this.AlgoGraph.getGraph().getE(theCurrent.getKey()) != null) {
                Iterator<edge_data> iterEdge = this.AlgoGraph.getGraph().getE(theCurrent.getKey()).iterator();
                while (iterEdge.hasNext()) {
                    edge_data tempEdge = iterEdge.next();
                    node_data src = this.AlgoGraph.getGraph().getNode(tempEdge.getSrc());
                    Point3D srcP = src.getLocation();
                    node_data dest = this.AlgoGraph.getGraph().getNode(tempEdge.getDest());
                    Point3D destP = dest.getLocation();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(srcP.x(), srcP.y(), destP.x(), destP.y());
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenColor(Color.BLUE);
                    StdDraw.text((srcP.x()*0.2 +destP.x()*0.8), (srcP.y()*0.2+destP.y()*0.8)+TheYUp, "" + tempEdge.getWeight());
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.25);
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.2);

                }
            }
        }
        ArrayList<Integer> save = this.MakeListInt(p);
        for (int i = 0; i < save.size()-1; i++) {
            int src = save.get(i);
            int dest = save.get(i+1);
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.line(this.AlgoGraph.getGraph().getNode(src).getLocation().x(),this.AlgoGraph.getGraph().getNode(src).getLocation().y(),this.AlgoGraph.getGraph().getNode(dest).getLocation().x(),this.AlgoGraph.getGraph().getNode(dest).getLocation().y());
            StdDraw.picture((this.AlgoGraph.getGraph().getNode(src).getLocation().x()+this.AlgoGraph.getGraph().getNode(dest).getLocation().x())/2 ,(this.AlgoGraph.getGraph().getNode(src).getLocation().y()+this.AlgoGraph.getGraph().getNode(dest).getLocation().y())/2 , "pic\\PostmanPat.jpg" , rightScaleX,rightScaleY);
        }
        StdDraw.createMenuBar();

    }
    public void update(){
        StdDraw.clear();
        Range x = returnTheX();
        Range y = returnTheY();
        StdDraw.setCanvasSize(700,700);
        double FixXscale = (x.get_max()-x.get_min())*0.2;
        double FixYscale = (y.get_max()-y.get_min())*0.2;
        StdDraw.setXscale(x.get_min()-FixXscale,x.get_max()*1.2);
        StdDraw.setYscale(y.get_min()-FixYscale,y.get_max()*1.2);
        double TheYUp = (y.get_max()-y.get_min())*0.03;
        double rightScaleX = ((x.get_max()-x.get_min())*0.04);
        double rightScaleY =  ((y.get_max()-y.get_min())*0.04);
        Iterator<node_data> iterNodes = this.AlgoGraph.getGraph().getV().iterator();
        while (iterNodes.hasNext()) {
            node_data theCurrent = iterNodes.next();
            StdDraw.picture(theCurrent.getLocation().x(),theCurrent.getLocation().y(),"pic\\light.jfif",rightScaleX,rightScaleY);
            Point3D tempP = theCurrent.getLocation();
            StdDraw.setPenColor(Color.black);
            StdDraw.text(tempP.x(), tempP.y()+TheYUp, "" + theCurrent.getKey());
            if (this.AlgoGraph.getGraph().getE(theCurrent.getKey()) != null) {
                Iterator<edge_data> iterEdge = this.AlgoGraph.getGraph().getE(theCurrent.getKey()).iterator();
                while (iterEdge.hasNext()) {
                    edge_data tempEdge = iterEdge.next();
                    node_data src = this.AlgoGraph.getGraph().getNode(tempEdge.getSrc());
                    Point3D srcP = src.getLocation();
                    node_data dest = this.AlgoGraph.getGraph().getNode(tempEdge.getDest());
                    Point3D destP = dest.getLocation();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(srcP.x(), srcP.y(), destP.x(), destP.y());
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setPenColor(Color.BLUE);
                    StdDraw.text((srcP.x()*0.2 +destP.x()*0.8), (srcP.y()*0.2+destP.y()*0.8)+TheYUp, "" + tempEdge.getWeight());
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.25);
                    StdDraw.setPenColor(Color.magenta);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.25);
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle((srcP.x()*0.1 +destP.x()*0.9), (srcP.y()*0.1 +destP.y()*0.9),rightScaleX*0.2);

                }
            }
        }
        StdDraw.createMenuBar();
    }
    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.AlgoGraph.getGraph().getMC() != CurrentMc) {
                CurrentMc = this.AlgoGraph.getGraph().getMC();
                update();
            }
        }
    }
    public void init(Graph_Algo g){
        this.AlgoGraph = g;
    }

    public static void main(String[] args) {
        Point3D x = new Point3D(-400,300,0);
        Point3D x2 = new Point3D(300,150,0);
        Point3D x3 = new Point3D(380,-300,0);
        Point3D x4 = new Point3D(150,-400,0);
        Point3D x5 = new Point3D(0,-450,0);
        Point3D x6 = new Point3D(200,-300,0);
        Point3D x7 = new Point3D(-400,-150,0);
        Point3D x8 = new Point3D(-400,120,0);
        NodeData a1 = new NodeData(x);
        NodeData a2 = new NodeData(x2);
        NodeData a3 = new NodeData(x3);
        NodeData a4 = new NodeData(x4);
        NodeData a5 = new NodeData(x5);
        NodeData a6 = new NodeData(x6);
        NodeData a7 = new NodeData(x7);
        NodeData a8 = new NodeData(x8);
        DGraph d = new DGraph();
        d.addNode(a1);
        d.addNode(a2);
        d.addNode(a3);
        d.addNode(a4);
        d.addNode(a5);
        d.addNode(a6);
        d.addNode(a7);
        d.addNode(a8);
        d.connect(1,2,5);
        d.connect(1,5,2);
        d.connect(1,3,6);
        d.connect(1,6,5);
        d.connect(3,4,7);
        d.connect(2,8,8);
        d.connect(2,7,3);
        d.connect(5,1,5);
        d.connect(5,6,2);
        d.connect(6,1,3);
        d.connect(6,5,3);
        d.connect(6,7,3);
        d.connect(7,6,3);
        Graph_Algo p = new Graph_Algo();
        p.init(d);
        List<Integer> r = new LinkedList<>();
        r.add(1);
        r.add(6);
        r.add(5);
        List<node_data> ans = p.TSP(r);
        MyGameGUI q = new MyGameGUI();
        q.init(p);
        q.MainDraw();
        double bbbb = p.shortestPathDist(3,4);
        //    List<node_data> theList = p.TSP(r);
        double eeeee = p.shortestPathDist(1,6);
        //     List<node_data> qqqq =  p.TSP(r);
        System.out.println(p.isConnected());
        System.out.println("r");
    }
}