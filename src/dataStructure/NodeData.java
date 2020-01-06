package dataStructure;

import utils.Point3D;
import java.io.Serializable;

public class NodeData implements node_data, Serializable {
    private int key , tag;
    public Point3D P3D;
    private double weight = Integer.MAX_VALUE;
    private String info;

    /**
     * constructor by Point3D
     * @param p
     */
    public NodeData(Point3D p){
        this.P3D = p;
    }

    /**
     * constructor by 3 points
     * @param x
     * @param y
     * @param z
     */
    public NodeData(double x, double y, double z){
        Point3D s = new Point3D(x,y,z);
        this.P3D = s;
    }
    public void setKey(int key){
        this.key = key;
    }
    public node_data copy(){
        NodeData n = new NodeData(this.getLocation().ix(),this.getLocation().iy(),this.getLocation().iz());
        n.setTag(this.getTag());
        n.setInfo(this.getInfo());
        n.setWeight(this.getWeight());
        return n;
    }
    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Point3D getLocation() {
        return this.P3D;
    }

    @Override
    public void setLocation(Point3D p) {
        Point3D s = new Point3D(p.x(),p.y(),p.z());
        this.P3D = s ;
        //DGraph.MC++;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }

}
