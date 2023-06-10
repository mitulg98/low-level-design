package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread oddWorker = new Thread(new TaskEvenOdd(printer, 15, false));
        Thread evenWorker = new Thread(new TaskEvenOdd(printer, 15, true));
        System.out.println(oddWorker.getState());

        oddWorker.start();
        evenWorker.start();
        Thread.sleep(1000);
        System.out.println(evenWorker.getPriority());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(oddWorker.getPriority());
    }
}

