package gameClient;


import dataStructure.*;
import utils.*;

public class Fruit implements Fruits {

    // Amazon = -1
    // Ebay = -2

    private Point3D location;
    int key,type ,tag=0;
    static int keyCounter = 1;
    double value;
    String info = "";
    String pic = "";



    public Fruit(Point3D loc){
        this.location = loc;
        this.key = keyCounter++;
    }



    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Point3D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(Point3D p) {
        this.location = p;
    }

    @Override
    public double getWeight() {
        return this.value;
    }

    @Override
    public void setWeight(double w) {
        this.value = w;
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


    @Override
    public void InsertAPicture(String file_name) {

    }

    @Override
    public int getType() {
        return  this.type ;
    }
}
