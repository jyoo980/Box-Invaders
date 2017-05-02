package MyFirstGame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by James on 2016-12-28.
 */

public class KeyInput extends KeyAdapter {
    private Handler gameHandler;        //this is the handler we're going to be using
    private boolean[] keyDown = new boolean[4]; //we have 4 boolean array inputs, i.e size 4


    /**
     * Sets this KeyInput's handler to the given handler
     * - Initializes the 4 locations of the keyDown array, all to false     *
     * @param handler
     */
    public KeyInput(Handler handler) {
        this.gameHandler = handler;

        for (int j = 0; j < keyDown.length; j++) {
            keyDown[j] = false;
        }

    }


    @Override
    public void keyPressed(KeyEvent e) {    //basically gets unique keybinding for each key pressed
        int key = e.getKeyCode();

        for (int j = 0; j < gameHandler.object.size(); j++) {
            GameObject tempObj = gameHandler.object.get(j);

            if (tempObj.getID() == ID.Player) {
                //TODO: Below are the KeyEvents for Player 1
                switch (key) {
                    case KeyEvent.VK_W:
                        tempObj.setvelY(-5);
                        keyDown[0] = true;
                        break;
                    case KeyEvent.VK_S:
                        tempObj.setvelY(5);
                        keyDown[1] = true;
                        break;
                    case KeyEvent.VK_D:
                        tempObj.setvelX(5);
                        keyDown[2] = true;
                        break;
                    case KeyEvent.VK_A:
                        tempObj.setvelX(-5);
                        keyDown[3] = true;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int j = 0; j < gameHandler.object.size(); j++) {
            GameObject tempObj = gameHandler.object.get(j);

            if (tempObj.getID() == ID.Player) {
                //TODO: Below are the KeyEvents for Player 1
                switch (key) {
                    case KeyEvent.VK_W:
                        keyDown[0] = false;
                        //tempObj.setvelY(0);
                        break;
                    case KeyEvent.VK_S:
                        keyDown[1] = false;
                        //tempObj.setvelY(0);
                        break;
                    case KeyEvent.VK_D:
                        keyDown[2] = false;
                        //tempObj.setvelX(0);
                        break;
                    case KeyEvent.VK_A:
                        keyDown[3] = false;
                        //tempObj.setvelX(0);
                }

                //vertical movement
                if (!keyDown[0] && !keyDown[1])  tempObj.setvelY(0);
                //horizontal movement
                if (!keyDown[2] && !keyDown[3])  tempObj.setvelX( 0);


            }
        }
    }











}
