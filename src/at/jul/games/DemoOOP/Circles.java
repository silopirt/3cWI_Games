package at.jul.games.DemoOOP;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circles {
    private enum DIRECTION{RIGHT,LEFT,UP,DOWN};
    private float x,y;
    private float diameter;
    private float speed;

    public Circles() {
        Random random = new Random();
        this.x = random.nextInt(790)+10;
        this.y = random.nextInt(590)+10;
        this.diameter = random.nextInt(35)+10;
        this.speed = random.nextInt(50)+10;
    }
    public void render(Graphics graphics){
        graphics.drawOval(this.x,this.y,10,10);
    }
    public void update(int delta){
        this.x -= (float) delta/this.speed;
        if(this.x - this.diameter <= 0){
            this.x = 800;
        }
    }
}
