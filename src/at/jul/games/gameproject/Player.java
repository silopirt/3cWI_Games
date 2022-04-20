package at.jul.games.gameproject;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player implements Actor {
    private Image manuelImage;
    private float x,y,width,height;
    private Shape collisionShape;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Player() throws SlickException {
        this.manuelImage = new Image("testdata/rocket.png");
        this.x = 100;
        this.y = 100;
        this.width = 50;
        this.height = 50;
        this.collisionShape = new Rectangle(this.x,this.y,this.width,this.height);
    }

    @Override
    public void render(Graphics graphics) {
        manuelImage.draw(this.x,this.y,width,height);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
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
}
