package model;

import ui.Game;
import ui.Window;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private Window.HeadUpDisplay hud;
    private int scoreCount;
    private Random rand;

    public Spawn(Handler handler, Window.HeadUpDisplay hud) {
        this.handler = handler;
        this.hud = hud;
        rand = new Random();
    }

    public void tick() {
        scoreCount++;
        if (scoreCount % 500 == 0) {
            incrementLevel();
            spawnBasicEnemy();
            if(scoreCount % 1000 == 0)
                spawnFasterAndSmarterEnemies();
        }
    }

    private void incrementLevel() {
        hud.setLevel(hud.getLevel() + 1);
    }

    private void spawnBasicEnemy() {
        BasicEnemy b = new BasicEnemy(rand.nextInt(Game.WIDTH), rand.nextInt(Game.HEIGHT), ID.Enemy, handler);
        handler.addObject(b);
    }

    private void spawnFasterAndSmarterEnemies() {
        FasterEnemy f = new FasterEnemy(rand.nextInt(Game.WIDTH), rand.nextInt(Game.HEIGHT), ID.FastEnemy, handler);
        SmartEnemy s = new SmartEnemy(rand.nextInt(Game.WIDTH), rand.nextInt(Game.HEIGHT), ID.SmartEnemy, handler);
        handler.addObject(f);
        handler.addObject(s);
    }
}