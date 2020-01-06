package Tests;
import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import org.junit.Test;
import utils.Point3D;

import static org.junit.Assert.*;

public class NodeDataTest {


    @Test
    public void getKey() {
        NodeData n = new NodeData(4,4,4);
        NodeData n2 = new NodeData(4,6,3);
        DGraph p = new DGraph();
        p.addNode(n);
        p.addNode(n2);
        assertEquals(1,n.getKey());
        assertEquals(2,n2.getKey());
    }

    @Test
    public void getLocation() {
        NodeData n = new NodeData(5,3,6);
        NodeData n1 = new NodeData(50,30,60);
        NodeData n2 = new NodeData(500,300,600);
        Point3D p = new Point3D(5,3,6);
        Point3D p1 = new Point3D(50,30,60);
        Point3D p2 = new Point3D(500,300,600);
        assertEquals(p,n.P3D);
        assertEquals(p1,n1.P3D);
        assertEquals(p2,n2.P3D);

    }

    @Test
    public void setLocation() {
        NodeData n2 = new NodeData(500,300,600);
        Point3D p = new Point3D(5,3,6);
        n2.setLocation(p);
        assertEquals(p,n2.P3D);

    }

    @Test
    public void getWeight() {
        NodeData n = new NodeData(5,3,6);
        NodeData n1 = new NodeData(50,30,60);
        NodeData n2 = new NodeData(500,300,600);
        n.setWeight(10);
        n1.setWeight(30);
        n2.setWeight(20);
        boolean flag1 = 10 == n.getWeight();
        boolean flag2 = 20 == n2.getWeight();
        boolean flag3 = 30 == n1.getWeight();
        assertEquals(true,flag1);
        assertEquals(true,flag2);
        assertEquals(true,flag3);
    }

    @Test
    public void setWeight() {
        NodeData n = new NodeData(5,3,6);
        NodeData n1 = new NodeData(50,30,60);
        NodeData n2 = new NodeData(500,300,600);
        n.setWeight(10);
        n1.setWeight(30);
        n2.setWeight(20);
        boolean flag1 = 10 == n.getWeight();
        boolean flag2 = 20 == n2.getWeight();
        boolean flag3 = 30 == n1.getWeight();
        assertEquals(true,flag1);
        assertEquals(true,flag2);
        assertEquals(true,flag3);
    }

    @Test
    public void getInfo() {
        NodeData n = new NodeData(3,3,3);
        n.setInfo("HAY");
        assertEquals("HAY",n.getInfo());
    }

    @Test
    public void setInfo() {
        NodeData n = new NodeData(3,3,3);
        n.setInfo("HAY");
        assertEquals("HAY",n.getInfo());
    }

    @Test
    public void getTag() {
        NodeData n = new NodeData(3,3,3);
        n.setTag(10);
        assertEquals(10,n.getTag());
    }

    @Test
    public void setTag() {
        NodeData n = new NodeData(3,3,3);
        n.setTag(10);
        assertEquals(10,n.getTag());
    }
}