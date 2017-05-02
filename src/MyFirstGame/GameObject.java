package MyFirstGame;

import java.awt.*;

/**
 * Created by James on 2016-12-28.
 * Basically, this is an ABSTRACT class because it refers to ALL of our
 * possible GameObjects i.e. enemies, heroes, items, players etc...
 */
public abstract class GameObject {

    float x,y;          // this is the location of each GameObject
    protected ID id;            // this represents the ID of the object, since it can be either a player or an enemy
    protected float velX, velY;   // this represents the x and y speed(s) of a given GameObject

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setID(ID id) { this.id = id; }

    public void setvelX(int velx) {
        this.velX = velx;
    }

    public void setvelY(int vely) {
        this.velY = vely;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getvelX() {
        return this.velX;
    }

    public float getVelY() {
        return this.velY;
    }

    public ID getID() { return this.id; }

    public abstract void tick();

    public abstract Rectangle getBounds();


    public abstract void render(Graphics g);






}
