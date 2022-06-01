package at.jul.games.designpatterns;

import at.jul.games.designpatterns.interfaces.Movement;

public class MoveRight implements at.jul.games.designpatterns.interfaces.Movement {
    private float x,y;
    private float speed;

    public MoveRight(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void update(int delta){
        this.x+= (float) delta/this.speed;
            if(this.x >=800){
                this.x = 0;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSpeed() {
        return speed;
    }
}
