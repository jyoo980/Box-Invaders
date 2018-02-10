package model;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private static LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void tick() {
        for (GameObject gameObj : gameObjects) {
            gameObj.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject gameObj : gameObjects) {
            gameObj.render(g);
        }
    }

    public void addObject(GameObject gameObj) {
        gameObjects.add(gameObj);
    }

    public void removeObject(GameObject gameObj) {
        gameObjects.remove(gameObj);
    }
}