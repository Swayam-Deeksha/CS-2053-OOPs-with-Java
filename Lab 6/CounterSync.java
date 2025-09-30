class Counter {
    int count = 0;

    // Synchronized method to ensure thread-safe increment
    synchronized void increment() {
        count++;
    }
}

class MyThread extends Thread {
    Counter counter;

    MyThread(Counter c) {
        counter = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class CounterSync {
    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.count);
    }
}