package java8;

public class Notify {
    volatile int balance = 10000;
    Object balanceLock = new Object();

    public void withdraw(int amt) {
        System.out.println("Withdrawing " + amt);
        while (this.balance < amt) {
            try {
                System.out.println("Not enough");
                wait();
            } catch (InterruptedException ie) {}
        }
        this.balance -= amt;
        System.out.println("Withdrawn successfully. Current amount " + this.balance );
    }

    public synchronized void deposit(int amt) {
        try {
            Thread.sleep(2000);
        }catch(InterruptedException ie) {}

        System.out.println("Deposit " + amt);
        this.balance += amt;
        System.out.println("Notifying other threads");
        notifyAll();
    }

    public static void main(String[] args) {
        Notify n = new Notify();
        Thread t1 = new Thread( () -> n.withdraw(20000) );
        Thread t2 = new Thread( () -> n.deposit(10000));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch( InterruptedException ie) {}
    }
}