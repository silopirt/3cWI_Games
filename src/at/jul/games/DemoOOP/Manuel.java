package at.jul.games.DemoOOP;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Manuel implements Actor{
    private Image manuelImage;
    public Manuel() throws SlickException {
        this.manuelImage = new Image("testdata/manuel.png");
    }

    @Override
    public void render(Graphics graphics) {
        manuelImage.draw(100,100,250,250);
    }

    @Override
    public void update(int delta) {

    }
}
