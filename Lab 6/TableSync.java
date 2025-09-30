class TablePrinter {
    // Synchronized method to ensure one thread prints the full table before the other
    synchronized void printTable(String threadName, int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " prints: " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(300); // slow down for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TableThread extends Thread {
    TablePrinter printer;
    String threadName;

    TableThread(TablePrinter p, String name) {
        printer = p;
        threadName = name;
    }

    public void run() {
        printer.printTable(threadName, 5);
    }
}

public class TableSync {
    public static void main(String[] args) {
        TablePrinter p = new TablePrinter();

        TableThread t1 = new TableThread(p, "Thread-A");
        TableThread t2 = new TableThread(p, "Thread-B");

        t1.start();
        t2.start();
    }
}