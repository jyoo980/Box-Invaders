package MyFirstGame;

import java.awt.*;
import java.util.Random;
import static MyFirstGame.HeadUpDisplay.greenValue;
import static java.util.Optional.empty;

/**
 * Created by James on 2016-12-28.
 */

public class Player extends GameObject{
    Random r = new Random();
    Handler handler;            //the handler associated with this specific Player GameObject
    boolean hitState;           //true if hit, else false

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        hitState = false;


    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;

        this.x = Game.clamp(this.x, 0, Game.WIDTH - 32);
        this.y = Game.clamp(this.y, 0, Game.HEIGHT - 72);

        handler.addObject(new Trail(x, y, 32, 32, 0.05f, ID.Player,Color.RED, handler));

        collision();

    }

    public void collision() {
        for (int j = 0; j < Handler.object.size(); j++) {
            GameObject tempObj = Handler.object.get(j);

            if (tempObj.getID() == ID.Enemy || tempObj.getID() == ID.FastEnemy) {
                if (tempObj.getBounds().intersects(this.getBounds())) {

                    HeadUpDisplay.HEALTH -= 2;  //if a collision occurs, then you subtract some of the health

                    hitState = true;

                    if (greenValue - 5 >= 0) {
                        greenValue -= 5;
                    } else
                        greenValue = 0;
                }
            }

        }
    }


    @Override
    public void render(Graphics g) {
       g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32,32);      //returns a rectangle at the posn of the Player, and of size of Player
    }






}
