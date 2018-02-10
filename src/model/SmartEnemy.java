package model;

import ui.Trail;

import java.awt.*;
import java.util.LinkedList;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject targetPlayer;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        initializeTarget();
    }

    private void initializeTarget() {
        LinkedList<GameObject> gameObjects = handler.getGameObjects();
        for (GameObject gameObj : gameObjects) {
            if (isTargetPlayer(gameObj)) {
                targetPlayer = gameObj;
            }
        }
    }

    private boolean isTargetPlayer(GameObject gameObj) {
        return (gameObj.getID() == ID.Player);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        setVelocity();
        generateTrail();
    }

    private void setVelocity() {
        float diffX = this.x - targetPlayer.getX() - 16;
        float diffY = this.y - targetPlayer.getY() - 16;
        float distance = (float)
                Math.sqrt((x-targetPlayer.getX())*(x-targetPlayer.getX()) + (y-targetPlayer.getY()*(y-targetPlayer.getY())));

        this.velX =  (float) ((-1.0/distance) * diffX);
        this.velY =  (float) ((-1.0/distance) * diffY);
    }

    private void generateTrail() {
        Trail t = new Trail(x ,y, 16, 16, 0.02f, ID.Trail, Color.ORANGE, handler);
        handler.addObject(t);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int) x, (int) y, 16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, 16, 16);
    }
}