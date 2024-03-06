package io.codeforall.ourgame;

public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();
        try {
            engine.init();
        } catch (InterruptedException ignored){}
    }
}