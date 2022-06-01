package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Movement;

public class MoveLeft implements Movement {
    private float x,y;
    private float speed;

    public MoveLeft(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public void update(int delta) {
        this.x-= (float) delta/this.speed;
        if(this.x <=0){
            this.x = 800;
        }
    }
}
