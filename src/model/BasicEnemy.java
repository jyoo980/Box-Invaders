package model;

import ui.Game;
import ui.Trail;
import java.awt.*;

public class BasicEnemy extends GameObject {
    private Handler handler;
    private static final int initialX = 5;
    private static final int initialY = 5;

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = initialX;
        velY = initialY;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        boundBasicEnemy();
        generateTrail();
    }

    private void boundBasicEnemy() {
        if (x <= 0 || x >= Game.WIDTH - 64) {
            velX *= -1;
        }
        if (y <= 0 || y >= Game.HEIGHT - 64) {
            velY *= -1;
        }
    }

    private void generateTrail() {
        Trail t = new Trail(x, y, 16, 16, 0.02f, ID.Trail, Color.CYAN, handler);
        handler.addObject(t);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}