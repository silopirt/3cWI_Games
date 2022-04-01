package at.jul.games.snowworld;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor{

    private float x,y;
    private float diameter;
    private float speed;

    public Snowflake() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600)-1000;
        this.diameter = random.nextInt(10)+3;
        if(this.diameter<=6){
            this.speed = 10;
        }else if(this.diameter <=10){
            this.speed = 8;
        }else if(this.diameter>=11){
            this.speed = 6;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x,this.y,this.diameter,this.diameter);
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta/this.speed;

        if(this.y+this.diameter >= 600){
            Random random = new Random();
            this.x = random.nextInt(800);
            this.y = random.nextInt(200)-400 ;
        }
    }
}
