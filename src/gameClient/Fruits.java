package gameClient;


import dataStructure.node_data;

public interface Fruits extends node_data {


    /**
     *To create a player in the game gave an option to insert a picture of that player
     * The player will be given an option not to insert a picture at all and this will be taken from the project
     *
**/
    public void setPicture(int type);
    /***
     * if the object is a player the function return true if the object is fruit the function return false ;
     */

    public int getType();

    public String getPicture();

}
