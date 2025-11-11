package com.library.services;

import java.util.List;

public class AutoSaveThread extends Thread {

    private List<?> books;
    private List<?> members;
    private List<?> transactions;
    private boolean running = true;

    // Shared lock object for wait/notify demo
    private final Object lock = new Object();

    public AutoSaveThread(List<?> books, List<?> members, List<?> transactions) {
        this.books = books;
        this.members = members;
        this.transactions = transactions;

        // Naming the thread
        this.setName("AutoSaveThread");

        // Setting thread priority
        this.setPriority(Thread.MIN_PRIORITY);

        // Setting as daemon thread
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (running) {
            try {
                System.out.println("🧵 Current Thread: " + Thread.currentThread().getName());
                System.out.println("Auto-saving data...");

                // Demonstrate yield() - allow other threads to execute
                Thread.yield();

                // Synchronization with wait/notify example
                synchronized (lock) {
                    System.out.println("Thread waiting for notification...");
                    lock.wait(1000); // waits for 1 second or until notified
                }

                // Save data
                synchronized (this) {
                    FileManager.saveBooks((List<?>) books);
                    FileManager.saveMembers((List<?>) members);
                    FileManager.saveTransactions((List<?>) transactions);
                }

                // Sleep for 5 seconds before next save
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("AutoSave thread interrupted.");
            }
        }
        System.out.println("AutoSaveThread stopped.");
    }

    public void notifyThread() {
        synchronized (lock) {
            System.out.println("🔔 Sending notification to waiting thread...");
            lock.notify();
        }
    }

    public void stopSaving() {
        running = false;
        this.interrupt();
    }

    public static void main(String[] args) {
        // Demo threads
        AutoSaveThread t1 = new AutoSaveThread(null, null, null);
        AutoSaveThread t2 = new AutoSaveThread(null, null, null);

        t1.start();
        t2.start();

        // Join example - wait for one thread before ending
        try {
            t1.join();
            System.out.println("✅ t1 finished before exiting main.");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

