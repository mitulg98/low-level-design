package org.example;

public class TaskEvenOdd implements Runnable {
    private final Printer printer;
    private final int limit;
    private final boolean isEven;

    public TaskEvenOdd(Printer printer, int limit, boolean isEven) {
        this.printer = printer;
        this.limit = limit;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while(number <= limit) {
            if(isEven) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}
