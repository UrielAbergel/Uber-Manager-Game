package gameClient;

import dataStructure.node_data;

public interface node_dataPlayer extends node_data {

    /**
     * This method comes to ask if the player is moving or is currently at a crossroads
     * @return the false if it doesnt moving
    */
    public boolean isMoving();

    /**
     *To create a player in the game gave an option to insert a picture of that player
     * The player will be given an option not to insert a picture at all and this will be taken from the project
     * */

    public void InsertAPicture(String file_name);

    /**
     *Represents the destination of the player he wants to reach
     * */

    public void GoToDest(int Dest);


}
