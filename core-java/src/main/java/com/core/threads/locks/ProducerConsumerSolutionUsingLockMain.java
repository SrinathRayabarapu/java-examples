package com.core.threads.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * program to use locks to achieve producer and consumer problem.
 *
 * @author Srinath.Rayabarapu
 */
public class ProducerConsumerSolutionUsingLockMain {

    public static void main(String[] args) {

        // Object on which producer and consumer threads will operate
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();

        // creating producer and consumer threads
        Producer p = new Producer(sharedObject);
        Consumer c = new Consumer(sharedObject);

        // starting both of them
        p.start();
        c.start();

    }

    /**
     * It's a shared object between producer and consumer threads.
     *
     * uses a queue of size 4, and a lock to be used in get and put methods. two conditions are used for letting the waiting
     * threads know whether queue is full or empty.
     */
    private static class ProducerConsumerImpl {

        private static final int CAPACITY = 4;
        private final Queue<Integer> queue = new LinkedList();
        private final Random random = new Random();

        private final Lock aLock = new ReentrantLock();
        // idea is to producer and consumer will operate only if buffer is full and empty
        private final Condition QUEUE_ADD = aLock.newCondition();
        private final Condition QUEUE_REMOVE = aLock.newCondition();

        /**
         * put the item into queue
         *
         * @throws InterruptedException
         */
        public void put() throws InterruptedException {
            aLock.lock();
            try {
                if(queue.size() == CAPACITY){
                    System.out.println(Thread.currentThread().getName() + ": Buffer is full, waiting..");
                    QUEUE_ADD.await();
                }

                int rand = random.nextInt(100);
                boolean isAdded = queue.offer(rand);
                if(isAdded){
                    System.out.printf("%s added %d into queue \n", Thread.currentThread().getName(), rand);
                    System.out.println(Thread.currentThread().getName() + ": Signalling that buffer is no more empty now");
                    QUEUE_REMOVE.signalAll();
                }

            }finally {
                aLock.unlock();
            }
        }

        /**
         * get the item from queue
         *
         * @throws InterruptedException
         */
        public void get() throws InterruptedException {
            aLock.lock();
            try {
                if(queue.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + ": buffer is empty, waiting..");
                    QUEUE_REMOVE.await();
                }
                Integer value = queue.poll();
                if(value != null){
                    System.out.printf("%s consumed %d from queue \n", Thread.currentThread().getName(), value);
                    System.out.println(Thread.currentThread().getName() + ": Signalling buffer may be empty now");
                    QUEUE_ADD.signalAll();
                }
                Thread.sleep(1000);
            }finally {
                aLock.unlock();
            }

        }

    }

    /**
     * producer which calls shared object put method
     */
    private static class Producer extends Thread{

        private ProducerConsumerImpl sharedObject;

        public Producer(ProducerConsumerImpl sharedObject) {
            super("Producer");
            this.sharedObject = sharedObject;
        }

        @Override
        public void run() {
//            while (true){ // just to run continuously
                try {
                    sharedObject.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }

    /**
     * consumer class which calls shared object get method
     */
    private static class Consumer extends Thread{

        private ProducerConsumerImpl sharedObject;

        public Consumer(ProducerConsumerImpl sharedObject) {
            super("Consumer");
            this.sharedObject = sharedObject;
        }

        @Override
        public void run() {
//            while (true){ // just to run continuously
                try {
                    sharedObject.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }
}
