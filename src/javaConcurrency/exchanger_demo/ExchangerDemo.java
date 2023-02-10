package javaConcurrency.exchanger_demo;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    /**
    *  In the program, the main( ) method creates an Exchanger for strings. This object is
     * then used to synchronize the exchange of strings between the MakeString and UseString
     * classes. The MakeString class fills a string with data. The UseString exchanges an empty
     * string for a full one. It then displays the contents of the newly constructed string. The
     * exchange of empty and full buffers is synchronized by the exchange( ) method, which is
     * called by both classes’ run( ) method.
    *
    * */
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        new CreateStringThread(stringExchanger);
        new GetStringThread(stringExchanger);
    }
}
