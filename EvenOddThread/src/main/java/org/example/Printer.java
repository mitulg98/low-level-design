package org.example;

public class Printer {
    private boolean isEvenTurn = false;

    public synchronized void printEven(int value) {
        while(!isEvenTurn) {
            try {
                wait();
                System.out.println(Thread.currentThread().getState());
            } catch (InterruptedException e) {
                Thread.currentThread()
                        .interrupt();
            }
        }

        isEvenTurn = false;
        System.out.println(value);
        notifyAll();
    }

    public synchronized void printOdd(int value) {
        while (isEvenTurn) {
            try {
                wait();
                System.out.println(Thread.currentThread().getState());
            } catch (InterruptedException e) {
                Thread.currentThread()
                        .interrupt();
            }
        }

        isEvenTurn = true;
        System.out.println(value);
        notifyAll();
    }
}
