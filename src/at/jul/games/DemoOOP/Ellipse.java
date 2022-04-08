package at.jul.games.DemoOOP;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor{
    private float x,y;
    private float speed;

    public Ellipse() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(10)+1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 50, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += (float) delta/this.speed;
        if(this.x+ 50 >= 800){
            this.x = 0;
        }
    }
}
