package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.pictures.*;

public class Bird {

    private Picture bird;
    private double speed;
    protected boolean crash;

    public Bird() {
        this.bird = new Picture(175, 350, "/flower.png");
        bird.draw();
    }

    public void gravity() {
        speed += 0.06;
        bird.translate(0, speed);
    }

    public void jump() {
        speed = -3;
    }

    public boolean isCrash() {
        return crash;
    }

    public int getX() {
        return bird.getX();
    }

    public int getY() {
        return bird.getY();
    }

    public void delete() {
        bird.delete();
    }

    public void redraw(int frameCounter) {
        if (frameCounter == 40){
            bird.delete();
            bird = new Picture(bird.getX(), bird.getY(), "/flower.png");
            bird.draw();
        } else if (frameCounter == 30){
            bird.delete();
            bird = new Picture(bird.getX(), bird.getY(),"/flower270.png" );
            bird.draw();
        } else if (frameCounter == 20){
            bird.delete();
            bird = new Picture(bird.getX(), bird.getY(),"/flower180.png" );
            bird.draw();
        } else if (frameCounter == 10){
            bird.delete();
            bird = new Picture(bird.getX(), bird.getY(),"/flower90.png" );
            bird.draw();
        }
    }
}