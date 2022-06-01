package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Actor;
import at.jul.games.designpatterns.interfaces.Movement;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class AbstractMove implements Actor {
    protected Movement movement;

    public AbstractMove(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        movement.update(delta);
    }

}
