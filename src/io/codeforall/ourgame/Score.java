package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private final Pipe gap;
    private final Bird phlox;
    protected int score;
    protected static int highScore;
    protected Text text = new Text(250,100, toString());

    public Score(Pipe gap, Bird phlox) {
        this.gap = gap;
        this.phlox = phlox;
        text.grow(30,30);
        text.draw();
    }

    public void scoreKeeper() {
        highScore = HighScoreManager.loadHighScore();
        for (int i = 0; i < gap.getGap().length; i++) {
            if (phlox.getX() == gap.getGap()[i].getX() + 75){
                score++;
                if(score > highScore){
                    highScore = score;
                    HighScoreManager.saveHighScore(highScore);
                }
                text.setText(toString());
                text.delete();
                text.draw();
            }
        }
    }

    public String toString(int highScore) {
        return "HIGHSCORE: " + highScore;
    }

    public String toString(Integer score) {
        return "SCORE: " + score;
    }

    @Override
    public String toString() {
        return "" + score;
    }

    public void delete(){
        text.delete();
    }
}