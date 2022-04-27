package at.jul.games.DemoOOP_;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Ellipse implements Actor{
    public enum DIRECTION{RIGHT,LEFT,UP,DOWN};
    private float x,y,speed,width,height;
    private DIRECTION direction;

    private Shape collisionShape;

    public Ellipse() {
        this.direction = DIRECTION.RIGHT;
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(10)+5;
        this.width = 50;
        this.height = 10;
        this.collisionShape = new org.newdawn.slick.geom.Ellipse(this.x,this.y,this.width/2,this.height/2);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.width, this.height);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(this.direction == Ellipse.DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x + 10 >= 800) {
                this.x = 0;
            }
        }else if(this.direction == Ellipse.DIRECTION.LEFT){
            this.x -= (float) delta / this.speed;
            if (this.x <= 0) {
                this.x = 800;
            }
        }else if(this.direction == Ellipse.DIRECTION.DOWN){
            this.y += (float) delta / this.speed;
            if (this.y + 10 >= 600) {
                this.y = 0;
            }
        }else if(this.direction == Ellipse.DIRECTION.UP){
            this.y -= (float) delta / this.speed;
            if (this.y<= 0) {
                this.y = 600;
            }
        }
        this.collisionShape.setCenterX(this.x+25);
        this.collisionShape.setCenterY(this.y+5);
    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public DIRECTION getDirection() {
        return direction;
    }
}
