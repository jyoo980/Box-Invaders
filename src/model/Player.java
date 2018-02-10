package model;

import ui.Game;
import ui.Trail;
import ui.Window;

import java.awt.*;
import java.util.LinkedList;
import static ui.Window.HeadUpDisplay.greenValue;

public class Player extends GameObject {
    private Handler handler;
    private boolean isPlayerHit;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        isPlayerHit = false;
    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;
        boundPlayer();
        generateTrail();
        collision();
    }

    private void boundPlayer() {
        this.x = Game.clamp(this.x, 0, Game.WIDTH - 32);
        this.y = Game.clamp(this.y, 0, Game.HEIGHT - 72);
    }

    private void generateTrail() {
        Trail t = new Trail(x, y, 32, 32, 0.05f, ID.Player,Color.RED, handler);
        handler.addObject(t);
    }

    private void collision() {
        LinkedList<GameObject> gameObjects = handler.getGameObjects();
        for (GameObject gameObj : gameObjects) {
            if (isEnemy(gameObj) && isColliding(gameObj)) {
                handleCollision();
            }
        }
    }

    private boolean isEnemy(GameObject gameObj) {
        return (gameObj.getID() == ID.Enemy || gameObj.getID() == ID.FastEnemy);
    }

    private boolean isColliding(GameObject gameObj) {
        return gameObj.getBounds().intersects(this.getBounds());
    }

    private void handleCollision() {
        isPlayerHit = true;
        Window.HeadUpDisplay.HEALTH -= 2;
        if (greenValue - 5 >= 0) {
            greenValue -= 5;
        } else {
            greenValue = 0;
        }
    }

    @Override
    public void render(Graphics g) {
       g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32,32);
    }
}