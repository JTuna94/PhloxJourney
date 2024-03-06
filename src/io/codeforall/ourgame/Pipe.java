package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pipe {

    private final Picture[] pipeUp = new Picture[4];
    private final Picture[] pipeDown = new Picture[4];
    private final Rectangle[] gap = new Rectangle[4];

    public Pipe() {

        int[] x = {900, 900, 900};
        for (int i = 0; i < gap.length; i++) {
            gap[i] = new Rectangle(x[0], (int) (Math.random() * 326 + 75), 75, 150);
            x[0] += 300;
        }
        for (int i = 0; i < pipeDown.length; i++) {
            pipeDown[i] = new Picture(x[1], gap[i].getY() + 150, "/bamboo.png");
            pipeDown[i].draw();
            x[1] += 300;
        }
        for (int i = 0; i < pipeUp.length; i++) {
            pipeUp[i] = new Picture(x[2], gap[i].getY() - 732, "/bamboo2.png");
            pipeUp[i].draw();
            x[2] += 300;
        }
    }

    public void movePipe() {
        for (Rectangle c : gap) {
            c.translate(-1, 0);
        }
        for (Picture c : pipeDown) {
            c.translate(-1, 0);
        }
        for (Picture c : pipeUp) {
            c.translate(-1, 0);
        }
    }

    public void createPipe() {
        for (int i = 0; i < gap.length; i++) {
            if (gap[i].getX() == -300) {
                gap[i].delete();
                gap[i] = new Rectangle(900, (int) (Math.random() * 326 + 75), 75, 150);
            }
        }
        for (int i = 0; i < pipeDown.length; i++) {
            if (pipeDown[i].getX() == -300) {
                pipeDown[i].delete();
                pipeDown[i] = new Picture(900, gap[i].getY() + 150, "/bamboo.png");
                pipeDown[i].draw();
            }
        }
        for (int i = 0; i < pipeUp.length; i++) {
            if (pipeUp[i].getX() == -300) {
                pipeUp[i].delete();
                pipeUp[i] = new Picture(900, gap[i].getY() - 732, "/bamboo2.png");
                pipeUp[i].draw();
            }
        }
    }

    public Rectangle[] getGap() {
        return gap;
    }

    public void delete() {
        for (Rectangle c : gap) {
            c.delete();
        }
        for (Picture c : pipeDown) {
            c.delete();
        }
        for (Picture c : pipeUp) {
            c.delete();
        }
    }
}