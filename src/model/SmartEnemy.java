package model;

import model.GameObject;
import model.Handler;
import model.ID;
import ui.Trail;

import java.awt.*;

/**
 * Created by James on 2017-01-01
 * This is a "smarter" enemy, i.e. this actually tracks the location of the player
 *
 */

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject targetPlayer;


    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int j = 0; j < handler.object.size(); j++) {
            if (handler.object.get(j).getID() == ID.Player)
                this.targetPlayer = handler.object.get(j);
                                            //searches through all GameObjects, if a player is found, then our
                                            //targetPlayer variable is initialized..
        }

    }



    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = this.x - targetPlayer.getX() - 16;
        float diffY = this.y - targetPlayer.getY() - 16;
        float distance = (float)
                Math.sqrt((x-targetPlayer.getX())*(x-targetPlayer.getX()) + (y-targetPlayer.getY()*(y-targetPlayer.getY())));

        this.velX =  (float) ((-1.0/distance) * diffX);
        this.velY =  (float) ((-1.0/distance) * diffY);

       // if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
       // if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;

        handler.addObject(new Trail(x ,y, 16, 16, 0.02f, ID.Trail, Color.ORANGE, handler));
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
