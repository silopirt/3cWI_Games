package at.jul.games.designpatterns;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private float x,y,height;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(400);
        this.y = random.nextInt(400);
        this.height = random.nextInt(10)+5;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += (float) delta/3;
        this.y += (float) delta/3;
        if(this.x >=800){
            this.x = 0;
        }
        if(this.y>=600){
            this.y = 0;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawOval(this.x,this.y,this.height,this.height);
    }
}
