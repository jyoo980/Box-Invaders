package MyFirstGame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by: James Yoo
 * Date: 2016-12-26
 *
 */
public class Game extends Canvas implements Runnable {
    public static Integer WIDTH = 1000;
    public static Integer HEIGHT = WIDTH / 12 * 9;   //basically gives 16:9 ratio
    private Thread thread;               //the entire game is going to run within this thread

    private boolean running = false;    //this basically means our game isn't running atm

    private static Handler gameHandler;        //this updates/renders ALL the GameObjects
    private HeadUpDisplay HUD;
    private Spawn spawner;
    private Random r;


    public static void main(String[] args) {
        new Game();

    }

    public Game() {
        gameHandler = new Handler();
        this.addKeyListener(new KeyInput(gameHandler));

        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);

        HUD = new HeadUpDisplay();

        spawner = new Spawn(gameHandler, HUD);


        r = new Random();                                         //initializes our Random variable


        gameHandler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, gameHandler));
        gameHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, gameHandler));

        /*
        for (int j = 0; j < 5; j++) {

            gameHandler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Enemy, gameHandler));
        }
        */         //we'll take care of spawning enemies in a new Spawner class


    }

    /**
     * Method that creates the thread we're gonna run our game in
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;     //the game is now running
    }

    /**
     * Method .join() kills the thread
     * i.e. this method will stop our game from running
     */
    public synchronized void stop() {
        try {
            thread.join();
            running = false;    //the game has now stopped running

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Basically, a method which acts as the "heartbeat" of the Game
     * Note: this code was obtained from the internet, I do NOT claim it as
     * code I have written myself - all credits and rights give to the
     * original developers.
     */
    public void run() {
        this.requestFocus();            //this is useful, automatically changes active window to this
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;

            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;

            }
        }

        stop();
    }


    private void tick() {

        gameHandler.tick();
        HUD.tick();
        spawner.tick();
    }

    private void render() {
        BufferStrategy bS = this.getBufferStrategy();
        if (bS == null) {
            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bS.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0, WIDTH, HEIGHT);

        gameHandler.render(g);
        HUD.render(g);

        g.dispose();
        bS.show();

    }

    public static float clamp(float var, float min, float max) {
        if (var >= max)         //if our current posn is greater than max
            return var = max;   //reset to our max,
        else if(var <= min)     //if our current posn is less than min
            return var = min;   //reset to min
        else
            return var;         //else it's all good
    }




}
