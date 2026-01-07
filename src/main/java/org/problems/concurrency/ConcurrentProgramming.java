package org.problems.concurrency;

public class ConcurrentProgramming {
    final int MAX_NUMBER = 50;
    boolean isEven = true;
    Object lock = new Object();
    Integer num = 44;
    boolean resource = true;
    public ConcurrentProgramming() throws RuntimeException, InterruptedException {
        //evenOddThreads();
        Thread evenThread = new Thread(()->{
            evenT();
        });
        Thread oddThread = new Thread(()->{
            oddT();
        });
        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
    }
    public synchronized void  evenT(){
        for(int i = 0; i < MAX_NUMBER; i=i+2){
                while(!resource){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                resource = false;
                System.out.println("Even Number from evenThread: " + i);
                notify();
            }

    }
    public synchronized void  oddT(){
        for(int i = 1; i < MAX_NUMBER; i=i+2){
            while(resource){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            resource = true;
            System.out.println("Even Number from oddThread: " + i);
            notify();
        }
    }
    public synchronized void  testThreads(){
        for(int i = 0; i < MAX_NUMBER; i=i+2){
            while(resource){
                try {
                    wait();
                    resource = false;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Even Number from evenThread: " + i);
            notify();
        }

    }

    public void evenOddThreads() throws RuntimeException, InterruptedException {
        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < MAX_NUMBER; i = i + 2) {
                synchronized (lock) {
                    while (!isEven) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lock.notify();
                    isEven = false;
                    System.out.println("Even Number from evenThread: " + i);
                }
            }
        });
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < MAX_NUMBER; i = i + 2) {
                synchronized (lock) {
                    while (isEven) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lock.notify();
                    isEven = true;
                    System.out.println("Odd Number from OddThread: " + i);
                }
            }
        });

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
    }
}
