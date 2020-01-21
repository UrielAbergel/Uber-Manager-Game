package dataStructure;

import Server.game_service;
import algorithms.GameAlgo;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import gameClient.Fruits;
import gameClient.Player;
import gameClient.Players;
import org.json.JSONException;

import java.util.ArrayList;
/**
 * This interface represents the full graph game.
 * The interface combine graph, player and fruits.
 * @author Yair Semama and Uriel Abergel
 */
public interface full_graph_game {

    /**
     * Get new game by scenario number and if the is auto or manual
     * @param sen
     */
    public void NewGAME(int sen , boolean isAuto);

    /**
     * init function.
     * @param g
     * @param p
     * @param f
     * @param algo
     */
    public void init(graph g, ArrayList<Players> p, ArrayList<Fruits> f,Graph_Algo algo);

    /**
     * @return game service
     */
    public game_service getGame();

    /**
     * sec game function
     * @param g
     */
    public void setGame(game_service g) throws JSONException;

    /**
     * get player list
     * @return List
     */
    public ArrayList<Players> getP();

    /**
     * get fruit list
     * @return List
     */
    public ArrayList<Fruits> getF();

    /**
     * get graph
     * @return graph
     */
    public graph getGraphM();

    /**
     * set graph
     * @param g
     */
    public void setGraphM(graph g);

    /**
     * ger Graph algorithem (class)
     * @return graph_algorithms
     */
    public graph_algorithms getAlgo();

    /**
     * add player to the list
     * @param p
     */
    public void addPlayer(Player p);

    /**
     * add fruit to the list
     * @param f
     */
    public void addFruits(Fruits f);

    /**
     * set player list
     * @param p
     */
    public void setPlayersList(ArrayList<Players> p);

    /**
     * set fruit list
     * @param f
     */
    public void setFruitList(ArrayList<Fruits> f);

    /**
     * @return GameAlgo
     */
    public GameAlgo getTheGameAlgo();

    /**
     * set GameAlgo
     * @param g
     */
    public void setTheGameAlgo(GameAlgo g);
}

