package at.jul.games.DemoOOP;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangles {
    private enum DIRECTION{RIGHT,LEFT,UP,DOWN};
    private float x;
    private float y;
    private float speed;

    public Rectangles() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);

        this.speed = random.nextInt(50)+10;
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,10,10);
    }
    public void update(int delta){
        this.x += (float) delta/this.speed;
        if(this.x + 10 >= 800){
            this.x = 0;
        }
    }
}
