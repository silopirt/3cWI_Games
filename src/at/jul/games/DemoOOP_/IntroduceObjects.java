package at.jul.games.DemoOOP_;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntroduceObjects extends BasicGame {
    private List<Actor> actors;
    private List<Actor> bullets;
    private Manuel manuel;

    public IntroduceObjects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        this.bullets = new ArrayList<>();

        Manuel manuel = new Manuel();
        this.manuel = manuel;
        this.actors.add(manuel);

        //for (int i = 0; i < 10; i++){
        //   Rectangles rectangle = new Rectangles(Rectangles.DIRECTION.UP);
        //    this.actors.add(rectangle);
        //}
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse();
            this.actors.add(ellipse);
            this.manuel.addEllipses(ellipse);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor:this.actors) {
            actor.update(gameContainer, delta);
        }
        for (Actor actor:this.bullets) {
            actor.update(gameContainer, delta);
        }

    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor:this.actors) {
            actor.render(graphics);
        }
        for (Actor actor:this.bullets) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.jul.games.DemoOOP_.IntroduceObjects("OOP"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
