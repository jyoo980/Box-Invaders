package model;

import java.awt.*;

public abstract class GameObject {
    protected float x,y;
    protected ID id;
    protected float velX, velY;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract Rectangle getBounds();

    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public void setvelX(int velx) {
        this.velX = velx;
    }

    public void setvelY(int vely) {
        this.velY = vely;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getvelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public ID getID() {
        return id;
    }
}