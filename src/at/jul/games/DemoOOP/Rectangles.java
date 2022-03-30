package at.jul.games.DemoOOP;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangles implements Actor{
    public enum DIRECTION{RIGHT,LEFT,UP,DOWN};

    private float x;
    private float y;
    private float speed;
    private DIRECTION direction;

    public Rectangles(DIRECTION direction) {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.direction = direction;


        this.speed = random.nextInt(50)+10;
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,10,10);
    }
    public void update(int delta){
        if(this.direction == DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x + 10 >= 800) {
                this.x = 0;
            }
        }else if(this.direction == DIRECTION.LEFT){
            this.x -= (float) delta / this.speed;
            if (this.x <= 0) {
                this.x = 800;
            }
        }else if(this.direction == DIRECTION.DOWN){
            this.y += (float) delta / this.speed;
            if (this.y + 10 >= 600) {
                this.y = 0;
            }
        }else if(this.direction == DIRECTION.UP){
            this.y -= (float) delta / this.speed;
            if (this.y<= 0) {
                this.y = 600;
            }
        }
    }
}
