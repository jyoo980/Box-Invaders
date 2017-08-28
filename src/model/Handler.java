package model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by James on 2016-12-28.
 * This updates all our objects that we will use in this game
 *
 */
public class Handler {
    public static LinkedList<GameObject> object = new LinkedList<>();     //this is the field which holds all the objects in game


    /**
     * Updates all the objects within the object LinkedList
     *
     */
    public void tick() {
        for (int j = 0; j < object.size(); j++) {
            GameObject tempObject = object.get(j);      //we temporarily grab an object from the list

            tempObject.tick();      //invoke the GameObject tick method on the object

        }
    }

    /**
     * Renders all the GameObjects within the LinkedList object
     * @param g
     */
    public void render(Graphics g) {
        for (int j = 0; j < object.size(); j++) {
            GameObject tempObject = object.get(j);

            tempObject.render(g);
        }

    }


    public void addObject(GameObject gO) {
        object.add(gO);
    }

    public void removeObject(GameObject gO) {
        object.remove(gO);

    }




}
