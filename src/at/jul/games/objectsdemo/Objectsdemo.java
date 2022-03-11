package at.jul.games.objectsdemo;

import org.newdawn.slick.*;

public class Objectsdemo extends BasicGame {
    private float x_rect;
    private float y_rect;

    private float y_circle;

    private float x_oval;


    public Objectsdemo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.x_rect +=(float) delta/8;
        this.y_rect +=(float) delta/8;

        this.y_circle += (float) delta/8;
        if(this.y_circle + 50 >= gameContainer.getHeight()){
            while (this.y_circle >= 0) {
                this.y_circle -= (float) delta / 8;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x_rect, this.y_rect,100,100);
        graphics.drawOval(this.x_oval,100,100,200);
        graphics.drawOval(0,this.y_circle,50,50);
    }
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objectsdemo("Demo"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
