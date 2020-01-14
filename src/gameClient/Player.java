package gameClient;

import algorithms.*;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Point3D;
import utils.StdDraw;

import java.util.LinkedList;
import java.util.List;

public class Player implements Players {
    int key, tag=0,speed = 0 ,dest,src;
    double weight = 0;
    Point3D location;
    String pic = "", info = "";


    public Player(String json) throws JSONException {
        JSONObject fruit = new JSONObject(json);
        JSONObject newFruit = fruit.getJSONObject("Robot");
        this.key = newFruit.getInt("id");
        this.src = newFruit.getInt("src");
        this.dest = newFruit.getInt("dest");
        this.speed = newFruit.getInt("speed");
        this.location = new Point3D(newFruit.getString("pos"));
        setPicture(this.key);
    }


    @Override
    public void setPicture(int key) {
        this.pic = "pic//"+((key%5)+1)+".jfif";
    }

    @Override
    public String getPicture() {
        return this.pic;
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

    public void MoveRobotToNextDest(int dest)
    {
        StdDraw.theMain.fullGame.getGame().chooseNextEdge(this.key, dest);
    }

    public static void main(String[] args) throws JSONException {
        Player p = new Player("{\"Robot\":{\"id\":0,\"value\":0.0,\"src\":1,\"dest\":-1,\"speed\":1.0,\"pos\":\"35.18958953510896,32.10785303529412,0.0\"}}");

    }
}
