package gameClient;

import dataStructure.node_data;

import java.util.List;
/**
 * This interface represents the player.
 * The player use to place on the graph for the travel and eat fruits
 * @author Yair Semama and Uriel Abergel
 */
public interface Players extends node_data {

    /**
     *To create a player in the game gave an option to insert a picture of that player
     * The player will be given an option not to insert a picture at all and this will be taken from the project
     * */
    public void setPicture(int key);

    /**
     * return the path to the player picture
     * @return String
     */
    public String getPicture();

    /**
     * return the player speed
     * @return
     */
    public int getSpeed();

    /**
     * set the player speed
     * @param speed
     */
    public void setSpeed(int speed);

    /**
     * det player destination
     * @return
     */
    public int getDest();

    /**
     * set player destination
     * @param dest
     */
    public void setDest(int dest);

    /**
     * get player source
     * @return
     */
    public int getSrc();

    /**
     * set player source
     * @param src
     */
    public void setSrc(int src);

    /**
     * return the move. use the server service.
     * @param dest
     */
    public void MoveRobotToNextDest(int dest);
}
