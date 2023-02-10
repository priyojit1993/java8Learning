package javaConcurrency.exchanger_demo;

import java.util.concurrent.Exchanger;

public class CreateStringThread implements Runnable {

    private Exchanger<String> exchanger;
    private String s;

    public CreateStringThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        s = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                s += ch++;
            }
            try {
                s = exchanger.exchange(s); // here this thread will exchange its value with the GetStringThread that will send an empty string
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
