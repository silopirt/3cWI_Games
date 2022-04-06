package at.jul.games.DemoOOP;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntroduceObjects extends BasicGame {
    private List<Actor> actors;

    public IntroduceObjects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Manuel manuel = new Manuel();
        this.actors.add(manuel);

        for (int i = 0; i < 10; i++){
            Rectangles rectangle = new Rectangles(Rectangles.DIRECTION.UP);
            this.actors.add(rectangle);
        }
        for (int i = 0; i < 10; i++) {
            Circles circle = new Circles();
            this.actors.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse();
            this.actors.add(ellipse);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor:this.actors) {
            actor.update(delta);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor:this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.jul.games.DemoOOP.IntroduceObjects("OOP"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
