package com.core.threads;

/**
 * same instance will be passed to different threads where object level lock is used for synchronization
 *
 * @author Srinath.Rayabarapu
 */
public class ObjectLevelLockMain {

    public static void main(String[] args) {
        ObjectLevelLock lockThread = new ObjectLevelLock();
        Thread t1 = new Thread(lockThread, "t1");
        t1.start();
        Thread t2 = new Thread(lockThread, "t2");
        t2.start();
        Thread t3 = new Thread(lockThread, "t3");
        t3.start();
    }

}

class ObjectLevelLock implements Runnable {

    private final Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("Running Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}