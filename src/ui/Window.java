package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    private static final long serialVersionUID = -2408460053372835L;

    public Window(int width, int height, String title, Game game) {
        JFrame window = new JFrame(title);
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
        public static int HEALTH = 100;
        public static int greenValue = 255;
        private static final int MAX_GREEN_VAL = 255;
        private int score;
        private int level;


        public HeadUpDisplay() {
            score = 0;
            level = 1;
        }

        public void tick(){
            clampGameValues();
            score++;
        }

        private void clampGameValues() {
            Game.clamp(HEALTH, 0, HEALTH);
            Game.clamp(greenValue, 0, MAX_GREEN_VAL);
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        private void render(Graphics g) {
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