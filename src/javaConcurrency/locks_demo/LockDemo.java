package javaConcurrency.locks_demo;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new MyThread("A", reentrantLock);
        new MyThread("B", reentrantLock);
        new MyThread("C", reentrantLock);


    }
}
