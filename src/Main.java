public class Main {
    static int c = 0;
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    public static void main(String[] args) {
        Thread thread0 = new Increment();
        Thread thread1 = new Decrement();
        thread0.start();
        thread1.start();
    }
}

class Increment extends Thread {
    @Override
    public void run() {
        this.setName("Thread A");
        int c = Main.c;
        Main.threadMessage(String.format("Retrieve %d.", c));
        Main.threadMessage(String.format("Increment retrieved value; result is %d.", ++c));
        Main.threadMessage(String.format("Store result in c; c is now %d.", Main.c = c));
    }
}
class Decrement extends Thread {
    @Override
    public void run() {
        this.setName("Thread B");
        int c = Main.c;
        Main.threadMessage(String.format("Retrieve %d.", c));
        Main.threadMessage(String.format("Decrement retrieved value; result is %d.", --c));
        Main.threadMessage(String.format("Store result in c; c is now %d.", Main.c = c));
    }
}