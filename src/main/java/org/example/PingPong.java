package org.example;
/** Реализация многопоточной программы "Пинг понг"*/
public class PingPong {
    private  String last="PONG";
     synchronized void action(String message) throws InterruptedException {
        while (true) {
            if (last.equals(message)) {
                wait();
            } else {
                System.out.println(message);
                last=message;
                Thread.sleep(1000);
                notifyAll();
            }
        }
    }
}
