package ru.vorotov;

public class Monitor {
    private boolean ready = false;

    public synchronized void provide() {
        if (ready)
            return;
        ready = true;
        notify();
        System.out.println("Поток-поставщик: событие инициировано");
    }

    public synchronized void consume() {
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
