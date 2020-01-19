package dataStructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class EdgeData implements edge_data, Serializable {
    private int src , dest;
    private double weight;
    private int Tag ;
    private String Info = "";

    /**
     * constructor
     * @param src
     * @param dest
     * @param weight
     * @param tag
     */
    public EdgeData(int src , int dest , double weight , int tag){
        this.src = src ;
        this.dest = dest ;
        this.weight = weight;
        this.Tag = tag;
    }

    /**
     * constructor
     * @param src
     * @param dest
     * @param weight
     */
    public EdgeData(int src , int dest , double weight){
        this.src = src ;
        this.dest = dest ;
        this.weight = weight;
        this.Tag = 0;
    }

    public EdgeData(edge_data edge) {

        this.src = edge.getSrc()  ;
        this.dest = edge.getDest() ;
        this.Info = edge.getInfo();
        this.Tag = edge.getTag();
       this.weight =edge.getWeight();

    }

    /**
     * Copy function
     * @return
     */
    public edge_data copy(){
        edge_data p = new EdgeData(this.src,this.dest,this.weight);
        p.setTag(this.Tag);
        p.setInfo(this.getInfo());
        return p ;
    }

    // --------------------------------------- getters and setters
    @Override
    public int getSrc()
    {
        return src;
    }

    @Override
    public int getDest() {
        return dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return this.Info;
    }

    @Override
    public void setInfo(String s) {
        this.Info=s;
    }

    @Override
    public int getTag()
    {
        return this.Tag;
    }

    @Override
    public void setTag(int t)
    {
        this.Tag = t ;
    }

    //---------------------------------------------

    /**
     * To String function
     * @param src
     * @param dest
     * @return
     */
    public static String toString(int src,int dest){
        return ""+src+","+dest;
    }
}
