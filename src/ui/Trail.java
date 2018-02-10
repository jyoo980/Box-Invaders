package ui;

import model.GameObject;
import model.Handler;
import model.ID;

import java.awt.*;

public class Trail extends GameObject {
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private float life;
    private int width, height;

    public Trail(float x, float y, int width, int height, float life, ID id, Color color, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.life = life;
        this.handler = handler;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x,(int)y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
}