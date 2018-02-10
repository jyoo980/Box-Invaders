package model;

import ui.Game;
import ui.Window;

import java.util.Random;

/**
 * Created by James on 2016-12-29.
 */
public class Spawn {
    private Handler handler;
    private Window.HeadUpDisplay hud;
    private int scoreCount;
    private Random r;

    public Spawn(Handler handler, Window.HeadUpDisplay hud) {
        this.handler = handler;
        this.hud = hud;
        r = new Random();

    }

    /**
     * Each time the "clock" reaches 1000, the level will increase by one.
     * - Every time the "clock" has a value of a multiple of 500, another enemy is added
     */
    public void tick() {
        scoreCount++;


        if (scoreCount % 500 == 0) {
            this.hud.setLevel(this.hud.getLevel() + 1);
            this.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, this.handler));

            if(scoreCount % 1000 == 0)
                this.handler.addObject(new FasterEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, this.handler));
                this.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, this.handler));


    }
    }

}


