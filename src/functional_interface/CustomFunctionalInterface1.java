package functional_interface;

public class CustomFunctionalInterface1 {
    /*Custom interface to print something on screen*/

    @FunctionalInterface
    interface PrintInterface {
        void printResult();
    }

    public static void main(String[] args) {
        PrintInterface printInterface = () -> System.out.println("Hello world");
        printInterface.printResult();
    }
}
