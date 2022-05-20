package at.jul.games.designpatterns;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private MoveRight mr;
    private float height;

    public Circle(MoveRight mr) {
        Random random = new Random();
        this.mr = mr;
        this.height = random.nextInt(10)+5;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        mr.update(delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        Random random = new Random();
        graphics.drawOval(this.mr.getX(),this.mr.getY(),this.height,this.height);
    }
}
