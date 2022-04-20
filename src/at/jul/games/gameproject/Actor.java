package at.jul.games.gameproject;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics);
    public void update(GameContainer gamecontainer,int delta);
}
