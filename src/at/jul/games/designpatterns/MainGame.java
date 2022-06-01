package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Actor;
import at.jul.games.designpatterns.interfaces.Movement;
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
        Random random = new Random();

        Player player = new Player();
        this.actors.add(player);
        for (int i = 0; i < 2; i++) {
            Movement mr = new MoveRight(random.nextInt(500)+50,random.nextInt(500)+50,random.nextInt(10)+3);
            Movement ml = new MoveLeft(random.nextInt(500)+50, random.nextInt(400)+50,random.nextInt(10)+3);

            Circle circle = new Circle(mr);
            Rectangle rectangle = new Rectangle(ml);

            this.actors.add(rectangle);
            this.actors.add(circle);
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
