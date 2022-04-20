package at.jul.games.DemoOOP_;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Circles implements DeletableActor {

    private float x,y;
    private float diameter;
    private float speed;
    private boolean isDeleteable = false;

    public Circles(float x, float y) {
        this.x = x;
        this.y = y;
        this.diameter = 10;
        this.speed = 10;
    }

    @Override
    public boolean isDeleteable() {
        return this.isDeleteable;
    }

    public void render(Graphics graphics){
        graphics.fillOval(this.x,this.y,this.diameter,this.diameter);

    }
    public void update(GameContainer gameContainer, int delta){
        this.y -= (float) delta/this.speed;
        if(this.y <= 0){
            this.isDeleteable=true;
        }
    }
}
