package at.jul.games.objectsdemo;

import org.newdawn.slick.*;

public class Objectsdemo extends BasicGame {
    private float x_rect;
    private float y_rect;
    private boolean isRectangleMovingRight = true;
    private boolean isRectangleMovingDown = true;

    private float y_circle;
    private boolean isCircleGoingDown = true;

    private float x_oval;
    private boolean isOvalMovingRight = true;


    public Objectsdemo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if(isRectangleMovingDown){
            this.y_rect +=(float) delta/8;
            if(this.y_rect + 100 >= gameContainer.getHeight()){
                this.isRectangleMovingDown = false;
            }
        }else {
            this.y_rect -= (float) delta/8;
            if(y_rect<=0){
                this.isRectangleMovingDown =true;
            }
        }
        if(isRectangleMovingRight){
            this.x_rect +=(float) delta/8;
            if(this.x_rect + 100 >= gameContainer.getWidth()){
                this.isRectangleMovingRight = false;
            }
        }else {
            this.x_rect -= (float) delta/8;
            if(x_rect<=0){
                this.isRectangleMovingRight =true;
            }
        }


        if (isCircleGoingDown){
            this.y_circle += (float) delta/8;
            if (this.y_circle + 50 >= gameContainer.getHeight()){
                this.isCircleGoingDown= false;
            }
        } else {
            this.y_circle -= (float) delta/8;
            if (this.y_circle<= 0){
                this.isCircleGoingDown= true;
            }
        }
        if (isOvalMovingRight){
            this.x_oval += (float) delta/8;
            if (this.x_oval+100 >= gameContainer.getWidth()){
                this.isOvalMovingRight= false;
            }
        } else {
            this.x_oval -= (float) delta/8;
            if (this.x_oval<= 0){
                this.isOvalMovingRight= true;
            }
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x_rect, this.y_rect,100,100);
        graphics.drawOval(this.x_oval,0,100,200);
        graphics.drawOval(0,this.y_circle,50,50);
    }
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.jul.games.objectsdemo.Objectsdemo("Demo"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
