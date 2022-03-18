package at.jul.games.DemoOOP;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntroduceObjects extends BasicGame {
    private List<Rectangles> rectangles;
    private List<Circles> circles;


    public IntroduceObjects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangles = new ArrayList<>();
        this.circles = new ArrayList<>();


        for (int i = 0; i < 100; i++){
            Rectangles rectangle = new Rectangles();
            this.rectangles.add(rectangle);
        }
        for (int i = 0; i < 30; i++) {
            Circles circle = new Circles();
            this.circles.add(circle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Rectangles rectangle:this.rectangles) {
            rectangle.update(delta);
        }
        for (Circles circle :this.circles) {
            circle.update(delta);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangles rectangle:this.rectangles) {
            rectangle.render(graphics);
        }
        for (Circles circle :this.circles) {
            circle.render(graphics);
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
