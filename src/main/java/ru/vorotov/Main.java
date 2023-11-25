package ru.vorotov;

public class Main {
    public static void main(String[] args) {
        int amountOfEvents = 5; // количеcтво событий
        Monitor monitor = new Monitor();

        // поток с функцией-поставщиком
        Thread producerThread = new Thread(() -> {
            // создание событий
            for (int i = 0; i < amountOfEvents; i++) {
                monitor.provide();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // поток с функцией-потребителем
        Thread consumerThread = new Thread(() -> {
            // создание получателей событий (количество получателей равно количеству событий)
            for (int i = 0; i < amountOfEvents; i++) {
                monitor.consume();
            }
        });

        // запуск потоков
        producerThread.start();
        consumerThread.start();
    }
}
