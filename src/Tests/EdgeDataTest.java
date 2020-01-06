package Tests;

import dataStructure.EdgeData;
import dataStructure.NodeData;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.*;

class EdgeDataTest {

    @org.junit.jupiter.api.Test
    void getSrc() {
        EdgeData test1 = new EdgeData(1,2,3);
        EdgeData test2 = new EdgeData(2,2,3);
        EdgeData test3 = new EdgeData(3,2,3);
        EdgeData test4 = new EdgeData(4,2,3);
        EdgeData test5 = new EdgeData(5,2,3);
        assertEquals(test1.getSrc(),1);
        assertEquals(test2.getSrc(),2);
        assertEquals(test3.getSrc(),3);
        assertEquals(test4.getSrc(),4);
        assertEquals(test5.getSrc(),5);

    }

    @org.junit.jupiter.api.Test
    void getDest() {
        EdgeData test1 = new EdgeData(1,1,3);
        EdgeData test2 = new EdgeData(2,2,3);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,3);
        EdgeData test5 = new EdgeData(5,5,3);
        assertEquals(test1.getSrc(),1);
        assertEquals(test2.getSrc(),2);
        assertEquals(test3.getSrc(),3);
        assertEquals(test4.getSrc(),4);
        assertEquals(test5.getSrc(),5);
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
        EdgeData test1 = new EdgeData(1,1,1);
        EdgeData test2 = new EdgeData(2,2,2);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,4);
        EdgeData test5 = new EdgeData(5,5,5);
        assertEquals(test1.getSrc(),1);
        assertEquals(test2.getSrc(),2);
        assertEquals(test3.getSrc(),3);
        assertEquals(test4.getSrc(),4);
        assertEquals(test5.getSrc(),5);
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
        EdgeData test1 = new EdgeData(1,1,1);
        EdgeData test2 = new EdgeData(2,2,2);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,4);
        EdgeData test5 = new EdgeData(5,5,5);
        test1.setInfo("this is the test1");
        test2.setInfo("this is the test2");
        test3.setInfo("this is the test3");
        test4.setInfo("this is the test4");
        assertEquals(test1.getInfo(),"this is the test1");
        assertEquals(test2.getInfo(),"this is the test2");
        assertEquals(test3.getInfo(),"this is the test3");
        assertEquals(test4.getInfo(),"this is the test4");


    }

    @org.junit.jupiter.api.Test
    void setInfo() {
        EdgeData test1 = new EdgeData(1,1,1);
        EdgeData test2 = new EdgeData(2,2,2);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,4);
        EdgeData test5 = new EdgeData(5,5,5);
        test1.setInfo("this is the test1");
        test2.setInfo("this is the test2");
        test3.setInfo("this is the test3");
        test4.setInfo("this is the test4");
        assertEquals(test1.getInfo(),"this is the test1");
        assertEquals(test2.getInfo(),"this is the test2");
        assertEquals(test3.getInfo(),"this is the test3");
        assertEquals(test4.getInfo(),"this is the test4");

    }

    @org.junit.jupiter.api.Test
    void getTag() {
        EdgeData test1 = new EdgeData(1,1,1);
        EdgeData test2 = new EdgeData(2,2,2);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,4);
        EdgeData test5 = new EdgeData(5,5,5);
        test1.setTag(1);
        test2.setTag(2);
        test3.setTag(3);
        test4.setTag(4);
        test5.setTag(5);
        assertEquals(test1.getTag(),1);
        assertEquals(test2.getTag(),2);
        assertEquals(test3.getTag(),3);
        assertEquals(test4.getTag(),4);
        assertEquals(test5.getTag(),5);
    }

    @org.junit.jupiter.api.Test
    void setTag() {
        EdgeData test1 = new EdgeData(1,1,1);
        EdgeData test2 = new EdgeData(2,2,2);
        EdgeData test3 = new EdgeData(3,3,3);
        EdgeData test4 = new EdgeData(4,4,4);
        EdgeData test5 = new EdgeData(5,5,5);
        test1.setTag(1);
        test2.setTag(2);
        test3.setTag(3);
        test4.setTag(4);
        test5.setTag(5);
        assertEquals(test1.getTag(),1);
        assertEquals(test2.getTag(),2);
        assertEquals(test3.getTag(),3);
        assertEquals(test4.getTag(),4);
        assertEquals(test5.getTag(),5);
    }


}