package MyFirstGame;

/**
 * Created by: James Yoo
 *
 */

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Window extends Canvas {

    private static final long serialVersionUID = -2408460053372835L;

    public Window(int width, int height, String title,Game game) {
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

}
