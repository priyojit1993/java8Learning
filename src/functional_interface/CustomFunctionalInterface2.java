package functional_interface;

public class CustomFunctionalInterface2 {
    /*
     * Custom functional interface to print the sum of 2 numbers on screen
     *
     * */
    @FunctionalInterface
    interface InterfacePrintSum {
        void printSum(int a, int b);
    }

    public static void main(String[] args) {
        InterfacePrintSum interfacePrintSum = (a, b) -> System.out.println("The sum of 2 numbers is : " + (a + b));
        interfacePrintSum.printSum(12, 23);
    }

}
