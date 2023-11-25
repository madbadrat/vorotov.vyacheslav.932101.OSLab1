package ru.vorotov;

public class Main {
    public static void main(String[] args) {
        int amountOfEvents = 5;
        Monitor monitor = new Monitor();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < amountOfEvents; i++) {
                monitor.provide();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            monitor.consume();
        });

        producerThread.start();
        consumerThread.start();
    }
}
