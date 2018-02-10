package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    private static final long serialVersionUID = -2408460053372835L;

    private Window(int width, int height, String title, Game game) {
        JFrame window = new JFrame(title);      //basically the frame of our game
        setWindowDimensions(window, width, height);
        setWindowBehaviour(window);

        addWindowStartGame(window, game);
    }

    private void setWindowDimensions(JFrame w, int width, int height) {
        Dimension defaultDimension = new Dimension(width, height);
        w.setPreferredSize(defaultDimension);
        w.setMaximumSize(defaultDimension);
        w.setMinimumSize(defaultDimension);
    }

    private void setWindowBehaviour(JFrame w) {
        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.setLocationRelativeTo(null);
    }

    private void addWindowStartGame(JFrame w, Game game) {
        w.add(game);
        w.setVisible(true);
        game.start();
    }


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
