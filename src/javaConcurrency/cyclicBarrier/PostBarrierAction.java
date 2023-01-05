package javaConcurrency.cyclicBarrier;

public class PostBarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier Ends");
    }
}
