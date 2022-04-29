package at.jul.games.DemoOOP_;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Ellipse implements Actor,CollisionShape{
    private float x,y,speed,width,height;

    private Shape collisionShape;

    public Ellipse() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(10)+1;
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
        this.x += (float) delta/this.speed;
        if(this.x+ 50 >= 800){
            this.x = 0;
        }
        this.collisionShape.setCenterX(this.x+25);
        this.collisionShape.setCenterY(this.y+5);
    }
    @Override
    public Shape getShape() {
        return collisionShape;
    }
}
