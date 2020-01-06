package Tests;

import dataStructure.DGraph;
import dataStructure.*;
import org.w3c.dom.Node;

import java.util.*;

import static org.junit.Assert.*;

public class DGraphTest {

    @org.junit.Test
    public void getNode() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1,2,3);
        NodeData test2 = new NodeData(1,2,3);
        NodeData test3 = new NodeData(1,2,3);
        NodeData test4 = new NodeData(1,2,3);
        NodeData test5 = new NodeData(1,2,3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        assertEquals(p.getNode(1),test1);
        assertEquals(p.getNode(2),test2);
        assertEquals(p.getNode(3),test3);
        assertEquals(p.getNode(4),test4);
        assertEquals(p.getNode(5),test5);
    }

    @org.junit.Test
    public void getEdge() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.connect(1, 6, 10);
        p.connect(2, 7, 10);
        p.connect(3, 8, 10);
        p.connect(4, 9, 10);
        p.connect(5, 10, 10);
        assertEquals(0, 0);
        boolean flag1 = p.edgeHM.get(1).containsKey(6);
        boolean flag2 = p.edgeHM.get(2).containsKey(7);
        boolean flag3 = p.edgeHM.get(3).containsKey(8);
        boolean flag4 = p.edgeHM.get(4).containsKey(9);
        boolean flag5 = p.edgeHM.get(5).containsKey(10);
        assertEquals(true, flag1);
        assertEquals(true, flag2);
        assertEquals(true, flag3);
        assertEquals(true, flag4);
        assertEquals(true, flag5);
    }

    @org.junit.Test
    public void addNode() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        assertEquals(p.getNode(1),test1);
        assertEquals(p.getNode(2),test2);
        assertEquals(p.getNode(3),test3);
        assertEquals(p.getNode(4),test4);
        assertEquals(p.getNode(5),test5);
        assertEquals(p.getNode(6),test11);
        assertEquals(p.getNode(7),test22);
        assertEquals(p.getNode(8),test33);
        assertEquals(p.getNode(9),test44);
        assertEquals(p.getNode(10),test55);
    }

    @org.junit.Test
    public void connect() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.connect(1, 6, 10);
        p.connect(2, 7, 10);
        p.connect(3, 8, 10);
        p.connect(4, 9, 10);
        p.connect(5, 10, 10);
        boolean flag1 = p.edgeHM.get(1).containsKey(6);
        boolean flag2 = p.edgeHM.get(2).containsKey(7);
        boolean flag3 = p.edgeHM.get(3).containsKey(8);
        boolean flag4 = p.edgeHM.get(4).containsKey(9);
        boolean flag5 = p.edgeHM.get(5).containsKey(10);
        boolean flag6 = p.edgeHM.get(5).containsKey(6);
        assertEquals(true, flag1);
        assertEquals(true, flag2);
        assertEquals(true, flag3);
        assertEquals(true, flag4);
        assertEquals(true, flag5);
        assertEquals(false, flag6);
    }

    @org.junit.Test
    public void getV() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
     //  HashMap r = (HashMap) p.getV();

//        assertEquals(r.get(0) , test1);
//        assertEquals(r.get(1) , test2);
//        assertEquals(r.get(2) , test3);
//        assertEquals(r.get(3) , test4);
//        assertEquals(r.get(4) , test5);
//        assertEquals(r.get(5) , test11);
//        assertEquals(r.get(6) , test22);
//        assertEquals(r.get(7) , test33);
//        assertEquals(r.get(8) , test44);
//        assertEquals(r.get(9) , test55);

    }

    @org.junit.Test
    public void getE() {
    }

    @org.junit.Test
    public void removeNode() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.removeNode(5);
        p.removeNode(10);
        assertEquals(null,p.getNode(5));
        assertEquals(null,p.getNode(10));
        assertNotEquals(null,p.getNode(2));

    }

    @org.junit.Test
    public void removeEdge() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.connect(1, 6, 10);
        p.connect(2, 7, 10);
        p.connect(3, 8, 10);
        p.connect(4, 9, 10);
        p.connect(5, 10, 10);
        assertEquals(p.getEdge(1,6),p.edgeHM.get(1).get(6));
        p.removeEdge(1,6);
        assertEquals(p.getEdge(1,6),null);
        assertEquals(p.getEdge(2,7),p.edgeHM.get(2).get(7));
        p.removeEdge(2,7);
        assertEquals(p.getEdge(2,7),null);
    }

    @org.junit.Test
    public void nodeSize() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        assertEquals(10,p.nodeSize());
        p.removeNode(5);
        p.removeNode(3);
        assertEquals(8,p.nodeSize());
    }

    @org.junit.Test
    public void edgeSize() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.connect(1, 6, 10);
        p.connect(2, 7, 10);
        p.connect(3, 8, 10);
        p.connect(4, 9, 10);
        p.connect(5, 10, 10);
        assertEquals(p.edgeSize(),5);
        p.removeEdge(2,7);
        p.removeEdge(3,8);
        assertEquals(3,p.edgeSize());
    }

    @org.junit.Test
    public void getMC() {
        DGraph p = new DGraph();
        NodeData test1 = new NodeData(1, 2, 3);
        NodeData test2 = new NodeData(1, 2, 3);
        NodeData test3 = new NodeData(1, 2, 3);
        NodeData test4 = new NodeData(1, 2, 3);
        NodeData test5 = new NodeData(1, 2, 3);
        NodeData test11 = new NodeData(1, 2, 3);
        NodeData test22 = new NodeData(1, 2, 3);
        NodeData test33 = new NodeData(1, 2, 3);
        NodeData test44 = new NodeData(1, 2, 3);
        NodeData test55 = new NodeData(1, 2, 3);
        p.addNode(test1);
        p.addNode(test2);
        p.addNode(test3);
        p.addNode(test4);
        p.addNode(test5);
        p.addNode(test11);
        p.addNode(test22);
        p.addNode(test33);
        p.addNode(test44);
        p.addNode(test55);
        p.connect(1, 6, 10);
        p.connect(2, 7, 10);
        p.connect(3, 8, 10);
        p.connect(4, 9, 10);
        p.connect(5, 10, 10);
        p.removeEdge(2,7);
        p.removeEdge(3,8);
        p.removeNode(3);
        assertEquals(18,p.getMC());
    }
}