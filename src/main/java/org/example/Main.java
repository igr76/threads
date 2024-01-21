package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        PingPong pingPong = new PingPong();
        new  Thread(()-> {
            try {
                pingPong.action("ping");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new  Thread(()-> {
            try {
                pingPong.action("PONG");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}