package javaConcurrency.exchanger_demo;

import java.util.concurrent.Exchanger;

public class GetStringThread implements Runnable {
    private Exchanger<String> exchanger;
    private String s;

    public GetStringThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                s = exchanger.exchange(new String());
                System.out.println("Got :" + s); //here the getStringThread exchanges the value with createString and provides a blank string to it in return.
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
