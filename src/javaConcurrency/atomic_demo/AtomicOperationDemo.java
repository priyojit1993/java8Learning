package javaConcurrency.atomic_demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperationDemo {
    public static void main(String[] args) {

        new MyThread("A");
        new MyThread("B");
        new MyThread("C");

    }
}
