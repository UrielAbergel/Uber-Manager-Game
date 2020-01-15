package gameClient;


import dataStructure.node_data;
/**
 * This interface represents the fruit.
 * The fruit use to place on the graph for the player to eat
 * @author Yair Semama and Uriel Abergel
 */
public interface Fruits extends node_data {
    /**
     * To create a fruit in the game gave an option to insert a picture of that fruit
     * The fruit will be given an option not to insert a picture at all and this will be taken from the project
     **/
    public void setPicture(int type);

    /***
     * if the object is a fruit the function return true if the object is fruit the function return false ;
     */
    public int getType();

    /**
     * return the path to the picture file
     *
     * @return
     */
    public String getPicture();
}
