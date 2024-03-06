package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.pictures.*;

public class Floor {

    private final Picture[] floor = new Picture[3];

    public Floor() {
        int x = 0;
        for (int i = 0; i < floor.length; i++, x += 300) {
            floor[i] = new Picture(x, 625, "/floor.png");
            floor[i].draw();
        }
    }

    public void moveFloor() {
        for (Picture f : floor) {
            f.translate(-1, 0);
        }
    }

    public void createFloor() {
        for (int i = 0; i < floor.length; i++) {
            if(floor[i].getX() == -300) {
                floor[i].delete();
                floor[i] = new Picture(600, 625, "/floor.png");
                floor[i].draw();
            }
        }
    }

    public void delete(){
        for (Picture f : floor) {
            f.delete();
        }
    }
}