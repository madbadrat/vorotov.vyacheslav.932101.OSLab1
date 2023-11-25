package ru.vorotov;

public class Monitor {
    private boolean ready = false; // флаг: показывает, инициировано ли событие

    // функция-поставщик
    public synchronized void provide() {
        if (ready)
            return;
        ready = true;
        notify();
        System.out.println("Поток-поставщик: событие инициировано");
    }

    // функция-потребитель
    public synchronized void consume() {
        // пока событие неинициировано, ожидаем
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ready = false;
        System.out.println("Поток-потребитель: событие получено");
    }
}
