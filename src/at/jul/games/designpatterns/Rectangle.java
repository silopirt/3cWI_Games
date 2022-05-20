package at.jul.games.designpatterns;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor{
    private float x,y,width,height;

    public Rectangle() {
        Random random = new Random();

        this.x = random.nextInt(400)+10;
        this.y = random.nextInt(400)+10;
        this.width = random.nextInt(50)+20;
        this.height = random.nextInt(50)+30;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.width,this.height);
    }
}
