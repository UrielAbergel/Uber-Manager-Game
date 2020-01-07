package gameClient;

import dataStructure.node_data;

import java.util.List;

public interface objects_on_the_map extends node_data {

    /**
     *To create a player in the game gave an option to insert a picture of that player
     * The player will be given an option not to insert a picture at all and this will be taken from the project
     * */

    public void InsertAPicture(String file_name);

    /***
     * if the object is a player the function return true if the object is fruit the function return false ;
     */

    public boolean WhatTypeAreYOU();


}
