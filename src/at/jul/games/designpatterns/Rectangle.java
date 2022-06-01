package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Movement;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle extends AbstractMove {
    public Rectangle(Movement movement) {
        super(movement);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.drawRect(this.movement.getX(),this.movement.getY(),20,20);
    }
}
