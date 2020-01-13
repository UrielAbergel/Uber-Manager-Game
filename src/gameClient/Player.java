package gameClient;

import algorithms.*;
import utils.Point3D;
import java.util.LinkedList;
import java.util.List;

public class Player implements Players {
    int key, tag=0,speed = 0 ,dest,src;
    double weight = 0;
    Point3D location;
    String pic = "", info = "";


    @Override
    public void InsertAPicture(String file_name) {
        this.pic = file_name;
    }


    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public void setDest(int dest) {
    this.dest = dest;
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public void setSrc(int src) {
        this.src = src ;
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
