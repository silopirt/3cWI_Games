package at.jul.games.DemoOOP_;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Manuel implements Actor{
    private Image manuelImage;
    private float x,y,width,height;
    private Shape collisionShape;
    private List<CollisionShape> collisionShapes;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Manuel() throws SlickException {
        this.manuelImage = new Image("testdata/manuel.png");
        this.x = 100;
        this.y = 100;
        this.width = 50;
        this.height = 50;
        this.collisionShape = new Rectangle(this.x,this.y,this.width,this.height);
        this.collisionShapes = new ArrayList<CollisionShape>();
    }

    @Override
    public void render(Graphics graphics) {
        manuelImage.draw(this.x,this.y,width,height);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (CollisionShape ellipse : collisionShapes) {
            if(this.collisionShape.intersects(ellipse.getShape())){
                System.out.println("col");
            }
        }

        if(gameContainer.getInput().isKeyDown(200)||gameContainer.getInput().isKeyDown(Input.KEY_W)){
            this.y -= (float) delta/5;
            if(this.y<= 0) {
                this.y = gameContainer.getHeight()-this.height;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN)||gameContainer.getInput().isKeyDown(Input.KEY_S)){
            this.y += (float) delta/5;
            if(this.y+this.height>= gameContainer.getHeight()) {
                this.y = 0;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)||gameContainer.getInput().isKeyDown(Input.KEY_D)){
            this.x += (float) delta/5;
            if(this.x+this.width>= gameContainer.getWidth()) {
                this.x = 0;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)||gameContainer.getInput().isKeyDown(Input.KEY_A)){
            this.x -= (float) delta/5;
            if(this.x<= 0) {
                this.x = gameContainer.getWidth()-this.width;
            }
        }
        this.collisionShape.setCenterX(this.x+25);
        this.collisionShape.setCenterY(this.y+25);

    }

    public void addEllipses(Ellipse ellipse){
        this.collisionShapes.add(ellipse);
    }
}
