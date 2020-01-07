package gameClient;

import algorithms.*;
import utils.Point3D;

import java.util.LinkedList;
import java.util.List;

public class Player implements objects_on_the_map {
    int key, tag=0;
    double weight = 0;
    Point3D location;
    String pic = "", info = "";

    public void InsertAPicture(String file_name) {
        this.pic = file_name;
    }

    @Override
    public boolean WhatTypeAreYOU() {
        return true;
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
