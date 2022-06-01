package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.Random;

public class Player implements Actor {
    private float x,y,speed,height,width;

    public Player() {
        Random random = new Random();
        this.x = 300;
        this.y = 300;
        this.height = 10;
        this.width = 10;
        this.speed =random.nextInt(5)+5;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_W)){
            this.y -= delta/this.speed;
            if(this.y<=0){
                this.y = 0;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            this.y += delta/this.speed;
            if(this.y>= gameContainer.getHeight()-this.height){
                this.y = gameContainer.getHeight()-this.height;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
            this.x += delta/this.speed;
            if(this.x>= gameContainer.getWidth()-this.width){
                this.x = gameContainer.getWidth()-this.width;
            }
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            this.x -= delta/this.speed;
            if(this.x<=0){
                this.x = 0;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.width,this.height);
    }
}
