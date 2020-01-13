package gameClient;

import dataStructure.node_data;

import java.util.List;

public interface Players extends node_data {

    /**
     *To create a player in the game gave an option to insert a picture of that player
     * The player will be given an option not to insert a picture at all and this will be taken from the project
     * */

    public void setPicture(int key);

    public String getPicture();

    public int getSpeed();

    public void setSpeed(int speed);

    public int getDest();

    public void setDest(int dest);

    public int getSrc();

    public void setSrc(int src);
    public void MoveRobotToNextDest(int dest);
}
