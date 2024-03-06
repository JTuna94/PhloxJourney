package io.codeforall.ourgame;

public class CollisionDetector {

    private final Bird phlox;
    private final Pipe pipe;

    public CollisionDetector(Bird phlox, Pipe pipe) {
        this.phlox = phlox;
        this.pipe = pipe;
    }

    public void check() {
        if (phlox.getY() >= 575) {
            phlox.crash = true;
        }
        for (int i = 0; i < pipe.getGap().length; i++) {
            if (phlox.getY() + 10 <= pipe.getGap()[i].getY() && phlox.getX() + 50 >= pipe.getGap()[i].getX() && phlox.getX() + 10 <= pipe.getGap()[i].getX() + 75) {
                phlox.crash = true;
            }
            if (phlox.getY() + 50 >= pipe.getGap()[i].getY() + 150 && phlox.getX() + 50 >= pipe.getGap()[i].getX() && phlox.getX() + 10 <= pipe.getGap()[i].getX() + 75) {
                phlox.crash = true;
            }
        }
    }
}