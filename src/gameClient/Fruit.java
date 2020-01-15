package gameClient;


import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
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
    long time = 0 ;


    public Fruit(){
        //for the algo not for use of the user
    }
    public Fruit(Point3D loc , int type){
        this.type = type;
        this.location = loc;
        this.key = keyCounter++;
    }
    public Fruit(String json , long time) throws JSONException {
        JSONObject fruit = new JSONObject(json);
        JSONObject newFruit = fruit.getJSONObject("Fruit");
        this.type = newFruit.getInt("type");
        this.value = newFruit.getInt("value");
        this.location = new Point3D(newFruit.getString("pos"));
        setPicture(this.type);
        this.time =time;
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
    public void setPicture(int type) {
        if (type == -1) {
            this.pic = "pic//Ebay.png";
            return;
        }
        if(type == 1) {
            this.pic = "pic//Amazon.png";
            return ;
        }
    }
    @Override
    public int getType() {
        return  this.type ;
    }


    @Override
    public String getPicture() {
        return this.pic;
    }
}
