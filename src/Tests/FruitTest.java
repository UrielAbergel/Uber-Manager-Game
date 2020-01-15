package Tests;

import gameClient.Fruit;
import org.junit.Test;
import utils.Point3D;

import static org.junit.Assert.*;

public class FruitTest {


    @Test
    public void getLocation() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();
        Fruit f3 = new Fruit();
        Fruit f4 = new Fruit();
        Fruit f5 = new Fruit();
        Point3D p1 = new Point3D(1,1,1);
        Point3D p2 = new Point3D(2,2,2);
        Point3D p3 = new Point3D(3,3,3);
        Point3D p4 = new Point3D(4,4,4);
        Point3D p5 = new Point3D(5,5,5);
        f1.setLocation(p1);
        f2.setLocation(p2);
        f3.setLocation(p3);
        f4.setLocation(p4);
        f5.setLocation(p5);
        assertEquals(p1,f1.getLocation());
        assertEquals(p2,f2.getLocation());
        assertEquals(p3,f3.getLocation());
        assertEquals(p4,f4.getLocation());
        assertEquals(p5,f5.getLocation());
    }

    @Test
    public void setLocation() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();
        Fruit f3 = new Fruit();
        Fruit f4 = new Fruit();
        Fruit f5 = new Fruit();
        Point3D p1 = new Point3D(1,1,1);
        Point3D p2 = new Point3D(2,2,2);
        Point3D p3 = new Point3D(3,3,3);
        Point3D p4 = new Point3D(4,4,4);
        Point3D p5 = new Point3D(5,5,5);
        f1.setLocation(p1);
        f2.setLocation(p2);
        f3.setLocation(p3);
        f4.setLocation(p4);
        f5.setLocation(p5);
        assertEquals(p1,f1.getLocation());
        assertEquals(p2,f2.getLocation());
        assertEquals(p3,f3.getLocation());
        assertEquals(p4,f4.getLocation());
        assertEquals(p5,f5.getLocation());
    }

    @Test
    public void getTag() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();
        Fruit f3 = new Fruit();
        Fruit f4 = new Fruit();
        Fruit f5 = new Fruit();
        f1.setTag(1);
        f2.setTag(2);
        f3.setTag(3);
        f4.setTag(4);
        f5.setTag(5);
        assertEquals(1,f1.getTag());
        assertEquals(2,f2.getTag());
        assertEquals(3,f3.getTag());
        assertEquals(4,f4.getTag());
        assertEquals(5,f5.getTag());

    }

    @Test
    public void setTag() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();
        Fruit f3 = new Fruit();
        Fruit f4 = new Fruit();
        Fruit f5 = new Fruit();
        f1.setTag(1);
        f2.setTag(2);
        f3.setTag(3);
        f4.setTag(4);
        f5.setTag(5);
        assertEquals(1,f1.getTag());
        assertEquals(2,f2.getTag());
        assertEquals(3,f3.getTag());
        assertEquals(4,f4.getTag());
        assertEquals(5,f5.getTag());
    }

    @Test
    public void setPicture() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();

        f1.setPicture(1);
        f2.setPicture(-1);

        assertEquals("pic//Amazon.png",f1.getPicture());
        assertEquals("pic//Ebay.png",f2.getPicture());


    }

    @Test
    public void getPicture() {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit();
        f1.setPicture(1);
        f2.setPicture(-1);
        assertEquals("pic//Amazon.png",f1.getPicture());
        assertEquals("pic//Ebay.png",f2.getPicture());
    }
}