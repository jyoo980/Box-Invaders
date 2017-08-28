package ui;

/**
 * Created by: James Yoo
 *
 */

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Window extends Canvas {

    private static final long serialVersionUID = -2408460053372835L;

    public Window(int width, int height, String title, Game game) {
        JFrame window = new JFrame(title);      //basically the frame of our game

        window.setPreferredSize(new Dimension(width, height));  //the preferred size our window will be
        window.setMaximumSize(new Dimension(width, height));    //the maximum size ...
        window.setMinimumSize(new Dimension(width, height));    //the minimum size ...

        window.setDefaultCloseOperation(EXIT_ON_CLOSE);     //this confirms the window will close when we exit
        window.setResizable(false);             //user cannot resize the window
        window.setLocationRelativeTo(null);     //default setting, makes window appear in centre of screen

        window.add(game);
        window.setVisible(true);    //this makes the window visible
        game.start();



    }

    /**
     * Created by James on 2016-12-28.
     */

    public static class HeadUpDisplay {
        public static int HEALTH = 100;     //this is the initial health that we start off with

        public static int greenValue = 255; //as this gradually decreases, so will our green colour intensity
                                            // we'll take care of this in our collision() method in the Player class

        public int score = 0;       //current score
        public int level = 1;       //the level we're at right now

        public HeadUpDisplay() {
            this.score = 0;
            this.level = 1;
        }



        public void tick(){
            Game.clamp(this.HEALTH, 0, HEALTH);
            Game.clamp(greenValue, 0, 255);

            score++;
        }

        public void setScore(int score) {
            this.score = score;

        }

        public void setLevel(int level) {
            this.level = level;

        }

        public int getScore() {
            return this.score;

        }


        public int getLevel() {
            return this.level;

        }

        public void render(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(15, 15, 200, 32);
            g.setColor(new Color(75, greenValue, 0));
            g.fillRect(15, 15, HEALTH*2, 32);
            g.setColor(Color.BLUE);
            g.drawRect(15, 15, HEALTH*2, 32);
            g.drawString("Current Score: " + score, 15, 70);
            g.drawString("Current Level: " + level, 15, 90);

        }

    }
}
