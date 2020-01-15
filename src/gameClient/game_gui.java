package gameClient;

import dataStructure.FullGameGraph;
import dataStructure.node_data;
import utils.Range;

import java.util.List;

/**
 * This interface represents graph GUI

 * @author Yair Semama and Uriel Abergel
 *
 */
public interface game_gui {
    /**
     * return the range for the x scale
     * @return
     */
    public Range returnTheX();

    /**
     * return the range for the y scale
     * @return
     */
    public Range returnTheY();

    /**
     * draw the GUI for the first time
     */
    public void MainDraw();

    /**
     * update the GUI after using TSP or shortest path function
     * @param p
     */
    public void update(List<node_data> p);

    /**
     * update after each change in the map
     */
    public void update();

    /**
     * init FullGameGraph.
     * @param g
     */
    public void init(FullGameGraph g);

}
