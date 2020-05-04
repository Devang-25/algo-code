package java8;

import java.util.LinkedList;

public class FairLockImpl {

    class FairLock {
        private boolean isLocked = false;
        private LinkedList<Object> q = new LinkedList<>();

        private Thread currentThread = null;

        public void lock() throws InterruptedException {
            System.out.println(" ------>" + Thread.currentThread().getName());
            Object lock = new Object();
            synchronized (this) {
                //System.out.println("Lock requested by thread " + Thread.currentThread().getName());
                q.offer(lock);
            }
            while (this.q.getFirst() != lock || isLocked) {
                synchronized(lock){
                    lock.wait();
                }
            }

            this.isLocked = true;
            this.currentThread = Thread.currentThread();
            this.q.removeFirst();

            // System.out.println("Lock acquired by thread " + this.currentThread.getName());
        }

        public void unlock() {
            synchronized (this) {
                // System.out.println("Lock released by thread " + this.currentThread.getName());
                this.isLocked = false;
                this.currentThread = null;

                if (!q.isEmpty()) {
                    synchronized(this.q.getFirst()){
                        this.q.getFirst().notify();
                    }
                }

                
            System.out.println("<------- " + Thread.currentThread().getName());
            }
        }

        public Thread getCurrentThread() {
            return currentThread;
        }
    }

    private FairLock fLock = new FairLock();

    public void executeWork() throws InterruptedException {
        fLock.lock();
        // System.out.println("Work execution by thread " + Thread.currentThread().getName());
        Thread.sleep(2000);
        fLock.unlock();

    }

    public static void main(String[] args) throws InterruptedException {
        FairLockImpl f = new FairLockImpl();
        Thread[] arr = new Thread[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        f.executeWork();
                    } catch (InterruptedException ex) {
                    }
                }
            }, Integer.toString(i));
            arr[i].start();
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].join();
        }
    }

}