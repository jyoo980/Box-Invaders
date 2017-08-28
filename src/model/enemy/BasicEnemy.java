package model.enemy;

import model.GameObject;
import model.Handler;
import model.ID;
import ui.Game;
import ui.Trail;

import java.awt.*;

/**
 * Created by James on 2016-12-28.
 */

public class BasicEnemy extends GameObject {
    private Handler handler;


    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;

        handler.addObject(new Trail(x ,y, 16, 16, 0.02f, ID.Trail, Color.CYAN, handler));
    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

}
