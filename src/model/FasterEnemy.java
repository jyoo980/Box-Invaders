package model;

import ui.Game;
import ui.Trail;

import java.awt.*;


public class FasterEnemy extends GameObject {
    private Handler handler;
    private static final int FASTER_ENEMY_VELX_START = 2;
    private static final int FASTER_ENEMY_VELY_START = 10;


    public FasterEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = FASTER_ENEMY_VELX_START;
        velY = FASTER_ENEMY_VELY_START;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        boundFasterEnemy();
        generateTrail();
    }

    private void boundFasterEnemy() {
        if (x <= 0 || x >= Game.WIDTH - 64) {
            velX *= -1;
        }
        if (y <= 0 || y >= Game.HEIGHT - 64) {
            velY *= -1;
        }
    }

    private void generateTrail() {
        Trail t = new Trail(x, y, 16, 16, 0.02f, ID.Trail, Color.BLACK, handler);
        handler.addObject(t);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}