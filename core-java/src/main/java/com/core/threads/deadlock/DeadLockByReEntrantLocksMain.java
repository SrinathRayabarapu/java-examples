package com.core.threads.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * program to demo deadlock by having two reentrant locks.
 *
 * @author Srinath.Rayabarapu
 */
public class DeadLockByReEntrantLocksMain {

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    private void processThis(){
        System.out.println("processThis(): Acquiring lockA");
        lockA.lock();
        System.out.println("processThis(): Acquiring lockB");
        lockB.lock();
        System.out.println("processThis(): Releasing lockA");
        lockA.unlock();
        System.out.println("processThis(): Releasing lockB");
        lockB.unlock();
    }

    private void processThat(){
        System.out.println("processThat(): Acquiring lockB");
        lockB.lock();
        System.out.println("processThat(): Acquiring lockA");
        lockA.lock();
        System.out.println("processThat(): Releasing lockB");
        lockB.unlock();
        System.out.println("processThat(): Releasing lockA");
        lockA.unlock();
    }

    public static void main(String[] args) {
        new DeadLockByReEntrantLocksMain().execute();
    }

    public void execute(){
        new Thread(this::processThis).start();
        new Thread(this::processThat).start();
    }

}
