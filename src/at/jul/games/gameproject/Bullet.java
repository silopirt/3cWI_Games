package at.jul.games.gameproject;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Bullet implements DeletableActor {

    private float x,y;
    private float diameter;
    private float speed;
    private boolean isDeleteable = false;
    private Shape collisionShape;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        this.diameter = 10;
        this.speed = 10;
        this.collisionShape = new Circle(this.x,this.y,5);
    }

    @Override
    public boolean isDeleteable() {
        return this.isDeleteable;
    }

    public void render(Graphics graphics){
        graphics.fillOval(this.x,this.y,this.diameter,this.diameter);
        graphics.draw(collisionShape);

    }
    public void update(GameContainer gameContainer, int delta){
        this.y -= (float) delta/this.speed;
        if(this.y <= 0){
            this.isDeleteable=true;
        }
        this.collisionShape.setCenterX(this.x+5);
        this.collisionShape.setCenterY(this.y+5);
    }
}
