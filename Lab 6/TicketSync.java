class TicketCounter {
    private int ticketsAvailable = 5;

    // Synchronized method to ensure safe booking
    synchronized void bookTicket(String userName) {
        if (ticketsAvailable > 0) {
            System.out.println(userName + " is booking a ticket...");
            try {
                Thread.sleep(300); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(userName + " successfully booked ticket #" + ticketsAvailable);
            ticketsAvailable--;
        } else {
            System.out.println(userName + " tried to book a ticket, but none are available.");
        }
    }
}

class MyThread extends Thread {
    TicketCounter counter;
    String userName;

    MyThread(TicketCounter tc, String name) {
        counter = tc;
        userName = name;
    }

    public void run() {
        counter.bookTicket(userName);
    }
}

public class TicketSync {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Simulate 8 users trying to book 5 tickets
        for (int i = 1; i <= 8; i++) {
            MyThread user = new MyThread(counter, "User-" + i);
            user.start();
        }
    }
}