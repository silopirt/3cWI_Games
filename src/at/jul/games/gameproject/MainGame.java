package at.jul.games.gameproject;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainGame extends BasicGame {
    private List<Actor> actors;
    private List<DeletableActor> bullets;
    private Player player;

    public MainGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        this.bullets = new ArrayList<>();

        Player player = new Player();
        this.player = player;
        this.actors.add(player);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor:this.actors) {
            actor.update(gameContainer, delta);
        }
        for (Actor actor:this.bullets) {
            actor.update(gameContainer, delta);
        }

        Iterator<DeletableActor> delActors = this.bullets.iterator();
        while(delActors.hasNext()){
            DeletableActor actor = delActors.next();
            if (actor.isDeleteable()){
                delActors.remove();
            }
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

    @Override
    public void keyPressed(int key, char c) {
        if(key == Input.KEY_SPACE){
            Bullet circle = new Bullet(player.getX(), player.getY());

            bullets.add(circle);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new MainGame("OOP"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
