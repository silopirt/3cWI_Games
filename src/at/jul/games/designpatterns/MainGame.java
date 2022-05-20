package at.jul.games.designpatterns;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGame extends BasicGame {
    private List<Actor> actors;

    public MainGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            MoveRight mr = new MoveRight(random.nextInt(500)+50,random.nextInt(500)+50,random.nextInt(10)+3);

            Circle circle = new Circle(mr);
            this.actors.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle();
            this.actors.add(rectangle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor:this.actors) {
            actor.update(gameContainer,delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor:this.actors) {
            actor.render(gameContainer, graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new MainGame("Design Patterns"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
