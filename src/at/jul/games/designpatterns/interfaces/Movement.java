package at.jul.games.designpatterns.interfaces;

import org.newdawn.slick.GameContainer;

public interface Movement {
    public float getX();
    public float getY();
    public void update(int delta);
}
