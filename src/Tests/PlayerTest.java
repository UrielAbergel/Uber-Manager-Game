package Tests;

import gameClient.Player;
import org.junit.Test;
import utils.Point3D;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getSpeed() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setSpeed(1);
        p2.setSpeed(2);
        p3.setSpeed(3);
        assertEquals(3,p3.getSpeed());
        assertEquals(2,p2.getSpeed());
        assertEquals(1,p1.getSpeed());
    }

    @Test
    public void setSpeed() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setSpeed(1);
        p2.setSpeed(2);
        p3.setSpeed(3);
        assertEquals(3,p3.getSpeed());
        assertEquals(2,p2.getSpeed());
        assertEquals(1,p1.getSpeed());
    }

    @Test
    public void getDest() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setDest(1);
        p2.setDest(2);
        p3.setDest(3);
        assertEquals(3,p3.getDest());
        assertEquals(2,p2.getDest());
        assertEquals(1,p1.getDest());
    }

    @Test
    public void setDest() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setDest(1);
        p2.setDest(2);
        p3.setDest(3);
        assertEquals(3,p3.getDest());
        assertEquals(2,p2.getDest());
        assertEquals(1,p1.getDest());
    }

    @Test
    public void getSrc() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setSrc(1);
        p2.setSrc(2);
        p3.setSrc(3);
        assertEquals(3,p3.getSrc());
        assertEquals(2,p2.getSrc());
        assertEquals(1,p1.getSrc());
    }

    @Test
    public void setSrc() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setSrc(1);
        p2.setSrc(2);
        p3.setSrc(3);
        assertEquals(3,p3.getSrc());
        assertEquals(2,p2.getSrc());
        assertEquals(1,p1.getSrc());
    }

    @Test
    public void getLocation() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Point3D PD1 = new Point3D(1,1);
        Point3D PD2 = new Point3D(2,2);
        Point3D PD3 = new Point3D(3,3);
        p1.setLocation(PD1);
        p2.setLocation(PD2);
        p3.setLocation(PD3);
        assertEquals(PD1,p1.getLocation());
        assertEquals(PD2,p2.getLocation());
        assertEquals(PD3,p3.getLocation());
    }

    @Test
    public void setLocation() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Point3D PD1 = new Point3D(1,1);
        Point3D PD2 = new Point3D(2,2);
        Point3D PD3 = new Point3D(3,3);
        p1.setLocation(PD1);
        p2.setLocation(PD2);
        p3.setLocation(PD3);
        assertEquals(PD1,p1.getLocation());
        assertEquals(PD2,p2.getLocation());
        assertEquals(PD3,p3.getLocation());
    }

    @Test
    public void getTag() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setTag(1);
        p2.setTag(2);
        p3.setTag(3);
        assertEquals(1,p1.getTag());
        assertEquals(2,p2.getTag());
        assertEquals(3,p3.getTag());
    }

    @Test
    public void setTag() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setTag(1);
        p2.setTag(2);
        p3.setTag(3);
        assertEquals(1,p1.getTag());
        assertEquals(2,p2.getTag());
        assertEquals(3,p3.getTag());
    }
}